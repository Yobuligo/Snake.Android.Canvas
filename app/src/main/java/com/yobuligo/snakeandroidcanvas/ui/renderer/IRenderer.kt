package com.yobuligo.snakeandroidcanvas.ui.renderer

import android.graphics.Canvas

interface IRenderer {
    fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes)
}