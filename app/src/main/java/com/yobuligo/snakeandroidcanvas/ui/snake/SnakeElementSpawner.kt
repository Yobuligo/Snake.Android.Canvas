package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.builder.Coordinate
import com.yobuligo.snakeandroidcanvas.builder.ICoordinate
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import kotlin.random.Random

class SnakeElementSpawner : ISnakeElementSpawner {
    private lateinit var snakeElement: ISnakeElement
    private var lastSpawnInMilli: Long = 0.toLong()

    override fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        spawnElement(cycleAttributes)

        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL

        paint.color = Color.GREEN
        val rect: Rect = Rect()
        rect.left = snakeElement.pos.x
        rect.top = snakeElement.pos.y
        rect.right = snakeElement.width
        rect.bottom = snakeElement.height
        canvas?.drawRect(rect, paint)
    }

    private fun spawnElement(cycleAttributes: ICycleAttributes) {
        if (needsSpawnElement(cycleAttributes) == false) {
            return
        }

        //TODO: Replace 800 by Gamefield Size
        val numberElementsX = 950 / Config.ELEMENT_SIZE
        val numberElementsY = 950 / Config.ELEMENT_SIZE

        //TODO Check for Collision
        snakeElement = SnakeElement(null)
        snakeElement.pos.x = Random.nextInt(2, numberElementsX) * Config.ELEMENT_SIZE
        snakeElement.pos.y = Random.nextInt(2, numberElementsY) * Config.ELEMENT_SIZE

        lastSpawnInMilli = cycleAttributes.currentTimeinMilli
    }

    private fun needsSpawnElement(cycleAttributes: ICycleAttributes): Boolean {
        if (lastSpawnInMilli == 0.toLong()) {
            lastSpawnInMilli = cycleAttributes.currentTimeinMilli
            return true
        }

        //Spawn each time a Snake Element
        val timeSpan: Long = cycleAttributes.currentTimeinMilli - lastSpawnInMilli
        if (timeSpan > 2000) {
            return true
        }

        return false
    }
}