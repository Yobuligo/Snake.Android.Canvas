package com.yobuligo.snakeandroidcanvas.builder

interface IFrameBuilder {
    fun setPosLeftTop(coordinate: ICoordinate)
    fun setPosRightBottom(coordinate: ICoordinate)
    fun setNoBorders()
    fun build()
}