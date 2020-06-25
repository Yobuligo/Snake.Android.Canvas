package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

interface ISnakeBuilder {
    fun setStartNumberElements(startNumberElements: Int): ISnakeBuilder
    fun setStartDirection(startDirection: Direction): ISnakeBuilder
    fun setStartPos(startPos: ICoordinate): ISnakeBuilder
    fun setMovable(movable: Boolean): ISnakeBuilder
    fun build(): ISnake
}