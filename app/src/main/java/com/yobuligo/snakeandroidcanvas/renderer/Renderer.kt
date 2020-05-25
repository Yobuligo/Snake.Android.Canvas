package com.yobuligo.snakeandroidcanvas.renderer

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.core.*
import com.yobuligo.snakeandroidcanvas.snake.model.ISnake

class Renderer() : IRenderer, IUpdater {
    override var elements: MutableList<IElement> = mutableListOf<IElement>()

    override fun render(canvas: Canvas?) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL

        for (element in elements) {
            if (element is ISnakeElement) {
                paint.color = Color.RED
            } else {
                paint.color = Color.BLUE
            }

            val rect: Rect = Rect()
            rect.left = element.posX
            rect.top = element.posY
            rect.right = element.width
            rect.bottom = element.heigth
            canvas?.drawRect(rect, paint)
        }
    }

    override fun update() {
        val mover: IMover = Mover(elements)
        mover.move()
    }
}