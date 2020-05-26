package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

interface ISnakeBuilder {
    fun setStartNumberElements(startNumberElements: Int)
    fun setStartDirection(startDirection: Direction)
    fun setStartPosX(startPosX: Int)
    fun setStartPosY(startPosY: Int)
    fun build(): ISnake
}