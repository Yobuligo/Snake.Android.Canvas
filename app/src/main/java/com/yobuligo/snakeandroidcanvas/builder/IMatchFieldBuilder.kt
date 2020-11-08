package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.ElementSize
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate

/**
 * Builder that is responsible for building the match field.
 * The match field is everything inside and inclusive the match field borders
 */
interface IMatchFieldBuilder {
    fun setPosLeftTop(coordinate: ICoordinate): IMatchFieldBuilder
    fun setPosRightBottom(coordinate: ICoordinate): IMatchFieldBuilder
    fun setNoBorders(): IMatchFieldBuilder
    fun setElementSize(elementSize: ElementSize): IMatchFieldBuilder
    fun build()
}