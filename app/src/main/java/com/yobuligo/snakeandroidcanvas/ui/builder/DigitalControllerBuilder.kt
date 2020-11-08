package com.yobuligo.snakeandroidcanvas.ui.builder

import com.yobuligo.snakeandroidcanvas.builder.IDigitalControllerBuilder
import com.yobuligo.snakeandroidcanvas.ui.controller.DigitalController
import com.yobuligo.snakeandroidcanvas.ui.controller.IDigitalController
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.renderer.RendererRepository
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeController

internal class DigitalControllerBuilder : IDigitalControllerBuilder {
    private lateinit var position: ICoordinate
    private var positionChanged: Boolean = false
    private var displayPauseButton: Boolean = false

    override fun setPosition(position: ICoordinate): IDigitalControllerBuilder {
        this.position = position
        positionChanged = true
        return this
    }

    override fun setDisplayPauseButton(): IDigitalControllerBuilder {
        this.displayPauseButton = true
        return this
    }

    override fun build(snakeController: ISnakeController): IDigitalController {
        if (positionChanged) {
            return DigitalController(snakeController, position, displayPauseButton)
        }

        val digitalController = DigitalController(snakeController, displayPauseButton)
        RendererRepository.instance.addRenderer(digitalController)
        return digitalController
    }
}