package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate

class ElementRepository private constructor() : IElementRepository {
    companion object {
        private val instance: IElementRepository = ElementRepository()

        public fun getInstance(): IElementRepository {
            return instance
        }
    }

    private val elementList: MutableList<IElement> = mutableListOf()

    override fun addElement(element: IElement) {
        elementList.add(element)
    }

    override fun removeElement(element: IElement) {
        elementList.remove(element)
    }

    override fun getElements(): List<IElement> {
        return elementList
    }

    override fun findElementsAtPos(coordinate: ICoordinate): List<IElement> {
        val elements: MutableList<IElement> = mutableListOf<IElement>()
        for (element in elementList) {
            if ((element.pos.x == coordinate.x) && (element.pos.y == coordinate.y)) {
                elements.add(element)
            }
        }
        return elements
    }
}