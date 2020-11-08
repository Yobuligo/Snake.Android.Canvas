package com.yobuligo.snakeandroidcanvas.ui.clickable

import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate

interface IClickable : ICoordinate {
    val width: Int
    val height: Int
    fun onClick()
}