package com.yobuligo.snakeandroidcanvas.core

import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElement
import com.yobuligo.snakeandroidcanvas.ui.snake.Snake
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeElement

class SnakeBuilder : ISnakeBuilder {
    private var startNumberElements: Int = 3
    private var startDirection: Direction =
        Direction.RIGHT
    private var startPosX: Int = 600
    private var startPosY: Int = 100

    override fun setStartNumberElements(startNumberElements: Int) {
        this.startNumberElements = startNumberElements
    }

    override fun setStartDirection(startDirection: Direction) {
        this.startDirection = startDirection
    }

    override fun setStartPosX(startPosX: Int) {
        this.startPosX = startPosX
    }

    override fun setStartPosY(startPosY: Int) {
        this.startPosY = startPosY
    }

    override fun build(): ISnake {
        val snake = Snake()
        snake.direction = startDirection
        snake.posX = startPosX
        snake.posY = startPosY
        var predecessor: IMovableElement = snake
        for (number in 1..startNumberElements) {
            val snakeElement =
                SnakeElement(predecessor)
            buildSnakeElement(snakeElement, predecessor)
            predecessor.follower = snakeElement
            predecessor = snakeElement
        }
        return snake
    }

    private fun buildSnakeElement(
        snakeElement: ISnakeElement,
        predecessor: IMovableElement
    ) {
        snakeElement.direction = predecessor.direction
        when (snakeElement.direction) {
            Direction.DOWN, Direction.UP, Direction.RIGHT -> snakeElement.posX =
                predecessor.posX - Config.ELEMENT_SIZE
            Direction.LEFT -> snakeElement.posX = predecessor.posX + Config.ELEMENT_SIZE
        }

        snakeElement.posY = predecessor.posY
    }

}