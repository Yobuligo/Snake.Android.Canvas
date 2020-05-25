package com.yobuligo.snakeandroidcanvas.core

import android.graphics.Canvas

interface IRenderer {
    var elements: MutableList<IElement>
    fun render(canvas: Canvas?)
}