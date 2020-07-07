package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.ui.element.ElementRepository
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawn

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
        val snakeElement = snake.createAndAppendCollectedSnakeElement()
        snakeElement.color = snakeElementSpawn.color
    }
}