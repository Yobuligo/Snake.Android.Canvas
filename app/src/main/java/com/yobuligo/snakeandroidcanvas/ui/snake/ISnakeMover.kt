package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes

interface ISnakeMover {
    fun move(snake: ISnake, cycleAttributes: ICycleAttributes)
}