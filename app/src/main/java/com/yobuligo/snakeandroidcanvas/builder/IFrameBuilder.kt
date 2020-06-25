package com.yobuligo.snakeandroidcanvas.builder

interface IFrameBuilder {
    fun setPosLeftTop(coordinate: ICoordinate): IFrameBuilder
    fun setPosRightBottom(coordinate: ICoordinate): IFrameBuilder
    fun setNoBorders(): IFrameBuilder
    fun build()
}