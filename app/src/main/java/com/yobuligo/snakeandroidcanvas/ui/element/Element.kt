package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.builder.Coordinate
import com.yobuligo.snakeandroidcanvas.builder.ICoordinate
import com.yobuligo.snakeandroidcanvas.options.Config

abstract open class Element : IElement {
    override var pos: ICoordinate = Coordinate(0, 0)
    override var width: Int = pos.x + Config.ELEMENT_SIZE
        get() = pos.x + Config.ELEMENT_SIZE
    override var height: Int = pos.y + Config.ELEMENT_SIZE
        get() = pos.y + Config.ELEMENT_SIZE

    init {
        val elementRepository = ElementRepository.getInstance()
        elementRepository.addElement(this)
    }
}