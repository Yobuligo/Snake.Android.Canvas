package com.yobuligo.snakeandroidcanvas.ui.controller

import android.graphics.Canvas
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickObserver
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickable
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

class DigitalController(val snakeController: ISnakeController) : IRenderer, IClickObserver {
    private val posY: Int = 1200
    private val cursorElementLeft = CursorElement(800, posY + 200, this)
    private val cursorElementRight = CursorElement(1200, posY + 200, this)
    private val cursorElementUp = CursorElement(1000, posY, this)
    private val cursorElementDown = CursorElement(1000, posY + 400, this)

    override fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        cursorElementLeft.render(canvas, cycleAttributes)
        cursorElementRight.render(canvas, cycleAttributes)
        cursorElementUp.render(canvas, cycleAttributes)
        cursorElementDown.render(canvas, cycleAttributes)
    }

    override fun onClick(clickable: IClickable) {
        when (clickable) {
            cursorElementLeft -> snakeController.onLeft()
            cursorElementRight -> snakeController.onRight()
            cursorElementUp -> snakeController.onUp()
            cursorElementDown -> snakeController.onDown()
        }
    }
}