package com.yobuligo.snakeandroidcanvas.ui.renderer

import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer

interface IRendererRepository {
    fun addRenderer(renderer: IRenderer)
    fun getRenderer(): List<IRenderer>
}