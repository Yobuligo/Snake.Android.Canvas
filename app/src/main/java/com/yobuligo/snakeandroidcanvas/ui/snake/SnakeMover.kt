package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.core.Config
import com.yobuligo.snakeandroidcanvas.core.Direction

class SnakeMover() : ISnakeMover {
    override fun move(snake: ISnake) {
        var element = snake.getLastElement()
        while (true) {
            if ((element != null) && (element.predecessor != null)) {
                element.posX = element.predecessor!!.posX
                element.posY = element.predecessor!!.posY
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
            Direction.RIGHT -> snake.posX = snake.posX + Config.ELEMENT_SIZE
            Direction.LEFT -> snake.posX = snake.posX - Config.ELEMENT_SIZE
            Direction.UP -> snake.posY = snake.posY - Config.ELEMENT_SIZE
            Direction.DOWN -> snake.posY = snake.posY + Config.ELEMENT_SIZE
        }
    }
}