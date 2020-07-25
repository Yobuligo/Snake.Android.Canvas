package com.yobuligo.snakeandroidcanvas.ui.renderer

interface IRendererRepository {
    fun addRenderer(renderer: IRenderer)
    fun getRenderer(): List<IRenderer>
}