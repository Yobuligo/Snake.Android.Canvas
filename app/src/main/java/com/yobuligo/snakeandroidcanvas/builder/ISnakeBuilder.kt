package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

interface ISnakeBuilder {
    var startNumberElements: Int
    var startDirection: Direction
    var startPos: ICoordinate
    var movable: Boolean
    fun build(): ISnake
}