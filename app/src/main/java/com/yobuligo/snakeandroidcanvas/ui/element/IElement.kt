package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate

interface IElement {
    var pos: ICoordinate
    var width: Int
    var height: Int
    var color: Int
    fun destroy()
}