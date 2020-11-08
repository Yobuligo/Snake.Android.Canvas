package com.yobuligo.snakeandroidcanvas.ui.renderer

import android.graphics.Canvas

/**
 * Object that needs to be rendered to be displayed on the canvas
 */
interface IRenderer {
    fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes)
}