package com.yobuligo.snakeandroidcanvas.ui.controller

import android.graphics.Canvas
import com.yobuligo.snakeandroidcanvas.builder.Coordinate
import com.yobuligo.snakeandroidcanvas.builder.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickObserver
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickable
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

class DigitalController(val snakeController: ISnakeController) : IDigitalController,
    IClickObserver {
    private var position: ICoordinate = Coordinate(800, 1200)
    private var cursorElementLeft = CursorElement(position.x, position.y + 200, this)
    private var cursorElementRight = CursorElement(position.x + 400, position.y + 200, this)
    private var cursorElementUp = CursorElement(position.x + 200, position.y, this)
    private var cursorElementDown = CursorElement(position.x + 200, position.y + 400, this)

    constructor(snakeController: ISnakeController, position: ICoordinate) : this(snakeController) {
        this.position = position
        cursorElementLeft = CursorElement(position.x, position.y + 200, this)
        cursorElementRight = CursorElement(position.x + 400, position.y + 200, this)
        cursorElementUp = CursorElement(position.x + 200, position.y, this)
        cursorElementDown = CursorElement(position.x + 200, position.y + 400, this)
    }

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