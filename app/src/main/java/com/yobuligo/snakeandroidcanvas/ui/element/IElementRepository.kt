package com.yobuligo.snakeandroidcanvas.ui.element

interface IElementRepository {
    fun addElement(element: IElement)
    fun removeElement(element: IElement)
    fun getElements(): List<IElement>
}