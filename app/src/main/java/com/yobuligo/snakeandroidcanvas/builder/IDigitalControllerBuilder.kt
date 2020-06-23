package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.controller.IDigitalController
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

interface IDigitalControllerBuilder {
    fun setPosition(position: ICoordinate): IDigitalControllerBuilder
    fun build(snakeController: ISnakeController): IDigitalController
}