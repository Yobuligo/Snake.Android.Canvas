package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.element.ElementRepository
import com.yobuligo.snakeandroidcanvas.ui.element.IElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElement

class CollisionDetector : ICollisionDetector {
    override fun checkSnake(snake: ISnake) {
        val elements = ElementRepository.getInstance().findElementsAtPos(snake.pos)
        if (elements.isEmpty()) {
            return
        }

        //is Snake Element -> Add element to snake
        for (element in elements) {
            if (element is ISnake) {
                continue
            }

            //Check is spawned snake element?
            if (element is ISnakeElement) {
                val lastElement = snake.getLastElement()

                element.direction = lastElement!!.direction
                element.predecessor = lastElement
                lastElement?.follower = element
                when (lastElement.direction) {
                    Direction.DOWN, Direction.UP, Direction.RIGHT -> element.pos.x =
                        lastElement.pos.x - Config.ELEMENT_SIZE
                    Direction.LEFT -> element.pos.x = lastElement.pos.x + Config.ELEMENT_SIZE
                }

                element.pos.y = lastElement.pos.y
            }
        }
    }
}