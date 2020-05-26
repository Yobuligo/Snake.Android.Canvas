package com.yobuligo.snakeandroidcanvas.builder

interface IFrameBuilder {
    fun setPosLeftTop(posLeftTop: ICoordinate)
    fun setPosLeftBottom(posLeftBottom: ICoordinate)
    fun setPosRightTop(posRightTop: ICoordinate)
    fun setPosRightBottom(posRightBottom: ICoordinate)
    fun build()
}