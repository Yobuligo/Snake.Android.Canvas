package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

interface ICollisionDetector {
    fun checkSnake(snake: ISnake)
}