package com.yobuligo.snakeandroidcanvas.ui.element

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
}