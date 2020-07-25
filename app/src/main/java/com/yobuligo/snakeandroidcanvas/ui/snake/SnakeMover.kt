package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes

class SnakeMover() : ISnakeMover {
    private var lastMoveInMilli: Long = 0.toLong()

    override fun move(snake: ISnake, cycleAttributes: ICycleAttributes) {
        if (!snake.movable) {
            return
        }

        if (!needsToMove(cycleAttributes)) {
            return
        }

        var element = snake.getLastSnakeElement()
        while (true) {
            if ((element != null) && (element.predecessor != null)) {
                element.pos.x = element.predecessor!!.pos.x
                element.pos.y = element.predecessor!!.pos.y
                element.direction = element.predecessor!!.direction
                element = element.predecessor!!
            } else {
                moveSnake(snake)
                updateLastMoveInMilli(cycleAttributes)
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

    private fun needsToMove(cycleAttributes: ICycleAttributes): Boolean {
        if (lastMoveInMilli == 0.toLong()) {
            return true
        }

        //TODO: Consider Speed here
        val timeSpan: Long = cycleAttributes.currentTimeinMilli - lastMoveInMilli
        if (timeSpan > Config.SPEED.value) {
            return true
        }

        return false
    }

    private fun updateLastMoveInMilli(cycleAttributes: ICycleAttributes) {
        lastMoveInMilli = cycleAttributes.currentTimeinMilli
    }
}