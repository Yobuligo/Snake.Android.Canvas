package com.yobuligo.snakeandroidcanvas.ui.renderer

import com.yobuligo.snakeandroidcanvas.ui.updater.IUpdater
import com.yobuligo.snakeandroidcanvas.ui.updater.UpdaterRepository

class RendererRepository private constructor() : IRendererRepository {
    private val rendererList: MutableList<IRenderer> = mutableListOf<IRenderer>()

    private object Singleton {
        val INSTANCE = RendererRepository()
    }

    companion object {
        val instance: RendererRepository by lazy { Singleton.INSTANCE }
    }

    override fun addRenderer(renderer: IRenderer) {
        rendererList.add(renderer)

        if (renderer is IUpdater) {
            val updater: IUpdater = renderer
            UpdaterRepository.instance.addUpdater(updater)
        }
    }

    override fun getRenderer(): List<IRenderer> {
        return rendererList
    }
}