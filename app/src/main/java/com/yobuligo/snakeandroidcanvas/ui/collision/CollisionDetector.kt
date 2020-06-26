package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.element.ElementRepository
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawn
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeElement

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
            if (element is ISnakeElementSpawn) {
                transferSnakeElementSpawntoSnakeElement(element, snake)
                element.destroy()
            }
        }
    }

    private fun transferSnakeElementSpawntoSnakeElement(
        snakeElementSpawn: ISnakeElementSpawn,
        snake: ISnake
    ) {
        val lastElement = snake.getLastElement()
        val snakeElement = SnakeElement(lastElement)
        snakeElement.color = snakeElementSpawn.color
        snakeElement.direction = lastElement!!.direction
        snakeElement.predecessor = lastElement
        lastElement?.follower = snakeElement
        when (lastElement.direction) {
            Direction.DOWN, Direction.UP, Direction.RIGHT -> snakeElement.pos.x =
                lastElement.pos.x - Config.ELEMENT_SIZE
            Direction.LEFT -> snakeElement.pos.x = lastElement.pos.x + Config.ELEMENT_SIZE
        }

        snakeElement.pos.y = lastElement.pos.y
    }
}