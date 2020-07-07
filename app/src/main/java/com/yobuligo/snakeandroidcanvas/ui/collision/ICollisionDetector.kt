package com.yobuligo.snakeandroidcanvas.ui.collision

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate
import com.yobuligo.snakeandroidcanvas.ui.element.IElement
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake

interface ICollisionDetector {
    fun checkSnake(snake: ISnake)
    fun isCoordinateOccupied(coordinate: ICoordinate): Boolean
    fun isElementCollided(element: IElement): Boolean
    fun getCollidedWithElementsByElement(element: IElement): List<IElement>
}