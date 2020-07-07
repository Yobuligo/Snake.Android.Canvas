package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Color
import android.util.Log
import com.yobuligo.snakeandroidcanvas.ui.color.ColorGenerator
import com.yobuligo.snakeandroidcanvas.ui.color.IColorGenerator
import com.yobuligo.snakeandroidcanvas.ui.element.IElement
import com.yobuligo.snakeandroidcanvas.ui.element.IElementDestroyListener
import com.yobuligo.snakeandroidcanvas.ui.playfield.PlayfieldAdministrator
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import java.util.*

class SnakeElementSpawner(val autoSpawnCycleInMilli: Long, val isMultiColor: Boolean) :
    ISnakeElementSpawner, IElementDestroyListener {
    private var lastSpawnInMilli: Long = 0.toLong()
    private val colorGenerator: IColorGenerator = ColorGenerator()
    private var hasActiveSnakeElementSpawn: Boolean = false

    override fun spawnElement(): ISnakeElementSpawn {
        var snakeElementSpawn = SnakeElementSpawn()
        snakeElementSpawn.pos = PlayfieldAdministrator.instance.getNextFreeRandomCoordinate()

        if (isMultiColor) {
            snakeElementSpawn.color = colorGenerator.next()
        } else {
            snakeElementSpawn.color = Color.RED
        }

        lastSpawnInMilli = Calendar.getInstance().timeInMillis
        snakeElementSpawn.setOnElementDestroyListener(this)

        hasActiveSnakeElementSpawn = true
        Log.i(
            "SnakeElementSpawner",
            "spawnElement: Snake Element Spawn was spawned at X: ${snakeElementSpawn.pos.x}, Y: ${snakeElementSpawn.pos.y} Color: ${snakeElementSpawn.color}"
        )

        return snakeElementSpawn
    }

    override fun update(cycleAttributes: ICycleAttributes) {
        spawnElementCyclic(cycleAttributes)
    }

    private fun spawnElementCyclic(cycleAttributes: ICycleAttributes) {
        if (needsSpawnElement(cycleAttributes) == false) {
            return
        }

        spawnElement()
    }

    private fun needsSpawnElement(cycleAttributes: ICycleAttributes): Boolean {
        if (lastSpawnInMilli == 0.toLong()) {
            lastSpawnInMilli = cycleAttributes.currentTimeinMilli
            Log.i(
                "SnakeElementSpawner",
                "needsSpawnElement: due to there was no element spawned yet"
            )
            return true
        }

        //Needs a snake element to be spawned each cycle?
        //if yes but the cycle is not finished yet leave anyway
        if (autoSpawnCycleInMilli.compareTo(0) == 1) {
            val timeSpan: Long = cycleAttributes.currentTimeinMilli - lastSpawnInMilli
            if (timeSpan > autoSpawnCycleInMilli) {
                Log.i("SnakeElementSpawner", "needsSpawnElement: due to autoSpawnCycletimer")
                return true
            }

            return false
        }

        //check if there is an active snake element spawn object
        //if not a new one has to be spawned
        if (!hasActiveSnakeElementSpawn) {
            Log.i(
                "SnakeElementSpawner",
                "needsSpawnElement: due to currently there is no active Snake Element Spawn"
            )
            return true
        }

        return false
    }

    override fun onElementDestroyed(element: IElement) {
        hasActiveSnakeElementSpawn = false
        if (element is ISnakeElementSpawn) {
            Log.i("SnakeElementSpawner", "onElementDestroyed: Snake Element Spawn was destroyed")
        } else {
            Log.i(
                "SnakeElementSpawner",
                "onElementDestroyed: another element was destroyed (not a Snake Element Spawn"
            )
        }
    }
}