package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate

interface IElementRepository {
    fun addElement(element: IElement)
    fun removeElement(element: IElement)
    fun getElements(): List<IElement>
    fun findElementsAtPos(coordinate: ICoordinate): List<IElement>
}