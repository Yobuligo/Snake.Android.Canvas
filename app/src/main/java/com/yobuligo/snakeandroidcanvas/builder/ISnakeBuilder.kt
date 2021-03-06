package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

/**
 * Builder that is responsible for building a snake
 */
interface ISnakeBuilder {
    fun setStartNumberElements(startNumberElements: Int): ISnakeBuilder
    fun setStartDirection(startDirection: Direction): ISnakeBuilder
    fun setStartPos(startPos: ICoordinate): ISnakeBuilder
    fun setMovable(movable: Boolean): ISnakeBuilder
    fun setSpeed(speed: Speed): ISnakeBuilder
    fun build(): ISnake
}