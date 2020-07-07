package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.element.ElementRepository
import com.yobuligo.snakeandroidcanvas.ui.element.IElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawn

class CollisionDetector : ICollisionDetector {
    companion object {
        val instance: ICollisionDetector by lazy<ICollisionDetector> {
            CollisionDetector()
        }
    }

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

    override fun isCoordinateOccupied(coordinate: ICoordinate): Boolean {
        return ElementRepository.getInstance().findElementsAtPos(coordinate).isEmpty().not()
    }

    override fun isElementCollided(element: IElement): Boolean {
        val elements = ElementRepository.getInstance().findElementsAtPos(element.pos)
        return (elements.contains(element) && elements.size > 1)
    }

    override fun getCollidedWithElementsByElement(element: IElement): List<IElement> {
        val elements: MutableList<IElement> = mutableListOf<IElement>()
        for (candidate in ElementRepository.getInstance().findElementsAtPos(element.pos)) {
            if (candidate == element) {
                continue
            }
            elements.add(candidate)
        }
        return elements
    }

    private fun transferSnakeElementSpawntoSnakeElement(
        snakeElementSpawn: ISnakeElementSpawn,
        snake: ISnake
    ) {
        val snakeElement = snake.createAndAppendCollectedSnakeElement()
        snakeElement.color = snakeElementSpawn.color
    }
}