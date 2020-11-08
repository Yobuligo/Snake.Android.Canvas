package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.controller.IDigitalController
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

/**
 * Builder that is responsible for building the controller to control the snake
 */
interface IDigitalControllerBuilder {
    fun setPosition(position: ICoordinate): IDigitalControllerBuilder
    fun setDisplayPauseButton(): IDigitalControllerBuilder
    fun build(snakeController: ISnakeController): IDigitalController
}