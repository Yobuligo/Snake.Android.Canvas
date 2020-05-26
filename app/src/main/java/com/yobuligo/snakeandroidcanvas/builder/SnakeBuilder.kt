package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElement
import com.yobuligo.snakeandroidcanvas.ui.snake.Snake
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeElement

internal class SnakeBuilder : ISnakeBuilder {
    override var startNumberElements: Int = 3
    override var startDirection: Direction = Direction.RIGHT
    override var startPos: ICoordinate = Coordinate(600, 100)
    override var movable: Boolean = true

    override fun build(): ISnake {
        val snake = Snake()
        snake.direction = startDirection
        snake.pos = startPos
        snake.movable = movable
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
            Direction.DOWN, Direction.UP, Direction.RIGHT -> snakeElement.pos.x =
                predecessor.pos.x - Config.ELEMENT_SIZE
            Direction.LEFT -> snakeElement.pos.x = predecessor.pos.x + Config.ELEMENT_SIZE
        }

        snakeElement.pos.y = predecessor.pos.y
    }

}