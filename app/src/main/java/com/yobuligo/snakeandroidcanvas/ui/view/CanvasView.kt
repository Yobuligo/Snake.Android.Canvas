package com.yobuligo.snakeandroidcanvas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.ui.renderer.RendererRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRendererRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.IUpdater

class CanvasView(context: Context) : View(context),
    IRendererRepository {
    private val rendererRepository: IRendererRepository =
        RendererRepository()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        renderCanvas(canvas)
        renderElements(canvas)
        Thread.sleep(Config.SPEED.value)
        invalidate()
    }

    override fun addRenderer(renderer: IRenderer) {
        rendererRepository.addRenderer(renderer)
    }

    override fun getRenderer(): List<IRenderer> {
        return rendererRepository.getRenderer()
    }

    private fun renderCanvas(canvas: Canvas?) {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas?.drawPaint(paint)
    }

    private fun renderElements(canvas: Canvas?) {
        for (renderer in rendererRepository.getRenderer()) {
            if (renderer is IUpdater) {
                val updater = renderer as IUpdater
                updater.update()
            }
            renderer.render(canvas)
        }
    }
}