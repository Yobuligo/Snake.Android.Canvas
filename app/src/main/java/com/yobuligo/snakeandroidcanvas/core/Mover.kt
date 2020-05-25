package com.yobuligo.snakeandroidcanvas.core

import com.yobuligo.snakeandroidcanvas.snake.model.ISnake

class Mover(val elements: List<IElement>) : IMover {
    override fun move() {
        for (index in elements.count() - 1 downTo 1) {
            val snakeElement = elements[index] as ISnakeElement
            snakeElement.posX = snakeElement.predecessor.posX
            snakeElement.posY = snakeElement.predecessor.posY
            snakeElement.direction = snakeElement.predecessor.direction
        }
    }
}