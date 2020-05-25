package com.yobuligo.snakeandroidcanvas.ui.renderer

class RendererRepository :
    IRendererRepository {
    private val rendererList: MutableList<IRenderer> = mutableListOf<IRenderer>()

    override fun addRenderer(renderer: IRenderer) {
        rendererList.add(renderer)
    }

    override fun getRenderer(): List<IRenderer> {
        return rendererList
    }
}