package com.yobuligo.snakeandroidcanvas.ui.builder

import com.yobuligo.snakeandroidcanvas.builder.ISnakeBuilder
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.core.Coordinate
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.renderer.RendererRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.SnakeRenderer
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.Snake

internal class SnakeBuilder : ISnakeBuilder {
    private var startNumberElements: Int = 3
    private var startDirection: Direction = Direction.RIGHT
    private var startPos: ICoordinate = Coordinate(600, 100)
    private var movable: Boolean = true
    private var speed: Speed = Speed.MIDDLE

    override fun setStartNumberElements(startNumberElements: Int): ISnakeBuilder {
        this.startNumberElements = startNumberElements
        return this
    }

    override fun setStartDirection(startDirection: Direction): ISnakeBuilder {
        this.startDirection = startDirection
        return this
    }

    override fun setStartPos(startPos: ICoordinate): ISnakeBuilder {
        this.startPos = startPos
        return this
    }

    override fun setMovable(movable: Boolean): ISnakeBuilder {
        this.movable = movable
        return this
    }

    override fun setSpeed(speed: Speed): ISnakeBuilder {
        this.speed = speed
        return this
    }

    override fun build(): ISnake {
        val snake = Snake()
        snake.direction = startDirection
        snake.pos = startPos
        snake.movable = movable
        snake.speed = speed
        for (number in 1..startNumberElements) {
            snake.createAndAppendInitialSnakeElement()
        }

        RendererRepository.instance.addRenderer(SnakeRenderer(snake))
        return snake
    }
}