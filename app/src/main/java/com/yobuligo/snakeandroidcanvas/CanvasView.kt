package com.yobuligo.snakeandroidcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View
import com.yobuligo.snakeandroidcanvas.core.*
import com.yobuligo.snakeandroidcanvas.renderer.Renderer
import com.yobuligo.snakeandroidcanvas.snake.model.ISnake
import java.time.Instant

class CanvasView(context: Context) : View(context) {
    private var posX: Float = 100f
    private var posY: Float = 100f
    private var direction: Boolean = true
    private var lastTimeStamp: Instant = Instant.now()
    lateinit var renderer: IRenderer
    lateinit var snake: ISnake
    var firstCycle: Boolean = true

    val speed: Speed = Speed.LIGHT

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (firstCycle) {
            firstCycle = false
            snake.direction = Direction.DOWN
        }

        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas?.drawPaint(paint)

        if (renderer is IUpdater) {
            val updater = renderer as IUpdater
            updater.update()
        }

/*
        if (snake.posX > 1100) {
            snake.direction = Direction.DOWN
        }

        if (snake.posY > 1100) {
            snake.direction = Direction.LEFT
        }

        if (snake.posY > 1100 && snake.posX < 200) {
            snake.direction = Direction.UP
        }

        if (snake.posY < 200 && snake.posX < 200) {
            snake.direction = Direction.RIGHT
        }
*/

        when (snake.direction) {
            Direction.RIGHT -> snake.posX = snake.posX + Config.ELEMENT_SIZE
            Direction.LEFT -> snake.posX = snake.posX - Config.ELEMENT_SIZE
            Direction.DOWN -> snake.posY = snake.posY + Config.ELEMENT_SIZE
        }


        renderer.render(canvas)

        Thread.sleep(speed.value)

        invalidate()
    }

}