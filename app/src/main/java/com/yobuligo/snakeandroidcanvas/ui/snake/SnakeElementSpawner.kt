package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Color
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.ui.color.ColorGenerator
import com.yobuligo.snakeandroidcanvas.ui.color.IColorGenerator
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import kotlin.random.Random

class SnakeElementSpawner(val autoSpawnCycleInMilli: Long, val isMultiColor: Boolean) :
    ISnakeElementSpawner {
    private var lastSpawnInMilli: Long = 0.toLong()
    private val colorGenerator: IColorGenerator = ColorGenerator()

    override fun update(cycleAttributes: ICycleAttributes) {
        spawnElement(cycleAttributes)
    }

    private fun spawnElement(cycleAttributes: ICycleAttributes) {
        if (needsSpawnElement(cycleAttributes) == false) {
            return
        }

        //TODO: Replace 800 by Gamefield Size
        val numberElementsX = 950 / Config.ELEMENT_SIZE
        val numberElementsY = 950 / Config.ELEMENT_SIZE

        //TODO Check for Collision
        val snakeElementSpawn = SnakeElementSpawn()
        snakeElementSpawn.pos.x = Random.nextInt(2, numberElementsX) * Config.ELEMENT_SIZE
        snakeElementSpawn.pos.y = Random.nextInt(2, numberElementsY) * Config.ELEMENT_SIZE

        if (isMultiColor) {
            snakeElementSpawn.color = colorGenerator.next()
        } else {
            snakeElementSpawn.color = Color.RED
        }

        lastSpawnInMilli = cycleAttributes.currentTimeinMilli
    }

    private fun needsSpawnElement(cycleAttributes: ICycleAttributes): Boolean {
        if (lastSpawnInMilli == 0.toLong()) {
            lastSpawnInMilli = cycleAttributes.currentTimeinMilli
            return true
        }

        //Needs a snake element to be spawned each cycle?
        if (autoSpawnCycleInMilli.compareTo(0) == 1) {
            val timeSpan: Long = cycleAttributes.currentTimeinMilli - lastSpawnInMilli
            if (timeSpan > autoSpawnCycleInMilli) {
                return true
            }
        }

        return false
    }
}