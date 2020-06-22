package com.yobuligo.snakeandroidcanvas.ui.clickable

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate

interface IClickable : ICoordinate {
    val width: Int
    val height: Int
    fun onClick()
}