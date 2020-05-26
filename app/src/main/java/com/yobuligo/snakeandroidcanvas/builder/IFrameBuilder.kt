package com.yobuligo.snakeandroidcanvas.builder

interface IFrameBuilder {
    var posLeftTop: ICoordinate
    var posRightBottom: ICoordinate
    fun build()
}