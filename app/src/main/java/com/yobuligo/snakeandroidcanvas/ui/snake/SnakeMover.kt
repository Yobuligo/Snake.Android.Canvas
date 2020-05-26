package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction

class SnakeMover() : ISnakeMover {
    override fun move(snake: ISnake) {
        var element = snake.getLastElement()
        while (true) {
            if ((element != null) && (element.predecessor != null)) {
                element.pos.x = element.predecessor!!.pos.x
                element.pos.y = element.predecessor!!.pos.y
                element.direction = element.predecessor!!.direction
                element = element.predecessor
            } else {
                moveSnake(snake)
                return
            }
        }
    }

    private fun moveSnake(snake: ISnake) {
        when (snake.direction) {
            Direction.RIGHT -> snake.pos.x = snake.pos.x + Config.ELEMENT_SIZE
            Direction.LEFT -> snake.pos.x = snake.pos.x - Config.ELEMENT_SIZE
            Direction.UP -> snake.pos.y = snake.pos.y - Config.ELEMENT_SIZE
            Direction.DOWN -> snake.pos.y = snake.pos.y + Config.ELEMENT_SIZE
        }
    }
}