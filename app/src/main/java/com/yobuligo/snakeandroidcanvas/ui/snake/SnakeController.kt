package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Direction

class SnakeController(val snake: ISnake) : ISnakeController {
    override fun onLeft() {
        snake.direction = Direction.LEFT
    }

    override fun onRight() {
        snake.direction = Direction.RIGHT
    }

    override fun onUp() {
        snake.direction = Direction.UP
    }

    override fun onDown() {
        snake.direction = Direction.DOWN
    }

    override fun onPause() {
        if (snake.movable) {
            snake.movable = false
        } else {
            snake.movable = true
        }
    }
}