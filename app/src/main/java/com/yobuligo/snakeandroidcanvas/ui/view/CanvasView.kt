package com.yobuligo.snakeandroidcanvas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.yobuligo.snakeandroidcanvas.ui.clickable.ClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.*
import java.util.*

class CanvasView(context: Context) : View(context),
    IRendererRepository {
    private val clickableRepository: IClickableRepository = ClickableRepository.getInstance()
    private val rendererRepository: IRendererRepository = RendererRepository()
    private var lastTimeInMilli: Long = 0.toLong()
    private var currentTimeInMilli: Long = 0.toLong()
    private var elapsedTimeInMilli: Long = 0.toLong()

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        renderCanvas(canvas)
        renderElements(canvas, createCycleAttributes())
        lastTimeInMilli = currentTimeInMilli
        invalidate()

    }

    private fun createCycleAttributes(): ICycleAttributes {
        calculateTimes()
        val cycleAttributes: ICycleAttributes =
            CycleAttributes(
                Calendar.getInstance().timeInMillis,
                lastTimeInMilli,
                elapsedTimeInMilli
            )
        return cycleAttributes
    }

    private fun calculateTimes() {
        currentTimeInMilli = Calendar.getInstance().timeInMillis
        if (lastTimeInMilli == 0.toLong()) {
            lastTimeInMilli = currentTimeInMilli
        }
        elapsedTimeInMilli = currentTimeInMilli - lastTimeInMilli
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val clickedPosX: Int = event!!.x.toInt()
        val clickedPosY: Int = event!!.y.toInt()
        clickableRepository.onClick(clickedPosX, clickedPosY)
        invalidate()
        return super.onTouchEvent(event)
    }

    private fun renderElements(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        for (renderer in rendererRepository.getRenderer()) {
            if (renderer is IUpdater) {
                val updater = renderer as IUpdater
                updater.update(cycleAttributes)
            }
            renderer.render(canvas, cycleAttributes)
        }
    }
}