package com.yobuligo.snakeandroidcanvas.ui.renderer

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElement
import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeMover
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeMover

class Renderer(val snake: ISnake) : IRenderer,
    IUpdater {
    override fun render(canvas: Canvas?) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL

        var movableElement: IMovableElement? = snake
        while (true) {
            if (movableElement != null) {
                if (movableElement is ISnakeElement) {
                    paint.color = Color.RED
                } else {
                    paint.color = Color.BLUE
                }

                val rect: Rect = Rect()
                rect.left = movableElement.posX
                rect.top = movableElement.posY
                rect.right = movableElement.width
                rect.bottom = movableElement.heigth
                canvas?.drawRect(rect, paint)
                movableElement = movableElement.follower
            } else {
                return
            }

        }
    }

    override fun update() {
        val snakeMover: ISnakeMover = SnakeMover()
        snakeMover.move(snake)
    }
}