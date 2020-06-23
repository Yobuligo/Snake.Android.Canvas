package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.controller.DigitalController
import com.yobuligo.snakeandroidcanvas.ui.controller.IDigitalController
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

class DigitalControllerBuilder : IDigitalControllerBuilder {
    private lateinit var position: ICoordinate
    private var positionChanged: Boolean = false

    override fun setPosition(position: ICoordinate) {
        this.position = position
        positionChanged = true
    }

    override fun build(snakeController: ISnakeController): IDigitalController {
        if (positionChanged) {
            return DigitalController(snakeController, position)
        }

        return DigitalController(snakeController)
    }
}