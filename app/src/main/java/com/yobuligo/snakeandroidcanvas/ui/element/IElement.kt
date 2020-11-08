package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate

/**
 * An implementation of that interface represents an element.
 * An element represents a part of the match field.
 * Parts of the match field e.g. borders, the snake, elements to be collected by the snake
 */
interface IElement {
    var pos: ICoordinate
    var width: Int
    var height: Int
    var color: Int
    fun destroy()
    fun setOnElementDestroyListener(elementDestroyListener: IElementDestroyListener)
}