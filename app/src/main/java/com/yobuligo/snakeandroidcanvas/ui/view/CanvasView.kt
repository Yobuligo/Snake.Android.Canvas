package com.yobuligo.snakeandroidcanvas.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import com.yobuligo.snakeandroidcanvas.ui.clickable.ClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.collision.CollisionDetector
import com.yobuligo.snakeandroidcanvas.ui.collision.ICollisionDetector
import com.yobuligo.snakeandroidcanvas.ui.renderer.*
import com.yobuligo.snakeandroidcanvas.ui.snake.Snake
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeRepository
import com.yobuligo.snakeandroidcanvas.ui.updater.IUpdater
import com.yobuligo.snakeandroidcanvas.ui.updater.IUpdaterRepository
import com.yobuligo.snakeandroidcanvas.ui.updater.UpdaterRepository
import java.util.*

class CanvasView(context: Context) : View(context),
    IRendererRepository, IUpdaterRepository {
    private val clickableRepository: IClickableRepository = ClickableRepository.getInstance()
    private val rendererRepository: IRendererRepository = RendererRepository()
    private val updaterRepository: IUpdaterRepository = UpdaterRepository()
    private val collisionDetector: ICollisionDetector = CollisionDetector()
    private var lastTimeInMilli: Long = 0.toLong()
    private var currentTimeInMilli: Long = 0.toLong()
    private var elapsedTimeInMilli: Long = 0.toLong()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val cycleAttributes = createCycleAttributes()
        updateElements(cycleAttributes)
        detectCollision(cycleAttributes)
        renderCanvas(canvas)
        renderElements(canvas, cycleAttributes)
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

        if (renderer is IUpdater) {
            val updater: IUpdater = renderer
            addUpdater(updater)
        }
    }

    override fun getRenderer(): List<IRenderer> {
        return rendererRepository.getRenderer()
    }

    private fun updateElements(cycleAttributes: ICycleAttributes) {
        for (updater in getUpdater()) {
            updater.update(cycleAttributes)
        }
    }

    private fun detectCollision(cycleAttributes: ICycleAttributes) {
        for (snake in SnakeRepository.getInstance().getSnakes()) {
            collisionDetector.checkSnake(snake)
        }
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
            renderer.render(canvas, cycleAttributes)
        }
    }

    override fun addUpdater(updater: IUpdater) {
        updaterRepository.addUpdater(updater)
    }

    override fun getUpdater(): List<IUpdater> {
        return updaterRepository.getUpdater()
    }
}