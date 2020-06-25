package com.yobuligo.snakeandroidcanvas.ui.renderer

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.ui.element.ElementRepository
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeMover
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeMover
import com.yobuligo.snakeandroidcanvas.ui.updater.IUpdater

class ElementRenderer(val snake: ISnake) : IRenderer,
        IUpdater {
        val snakeMover: ISnakeMover = SnakeMover()

    override fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL

        val elementRepository = ElementRepository.getInstance()
        for (element in elementRepository.getElements()) {
            paint.color = element.color
            val rect: Rect = Rect()
            rect.left = element.pos.x
            rect.top = element.pos.y
            rect.right = element.width
            rect.bottom = element.height
            canvas?.drawRect(rect, paint)
        }
    }

    override fun update(cycleAttributes: ICycleAttributes) {
        snakeMover.move(snake, cycleAttributes)
    }
}