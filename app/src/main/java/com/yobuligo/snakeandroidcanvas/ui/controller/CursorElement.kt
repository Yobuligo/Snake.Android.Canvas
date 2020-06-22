package com.yobuligo.snakeandroidcanvas.ui.controller

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.ui.clickable.ClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickObserver
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickable
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes

class CursorElement(override var x: Int, override var y: Int, val clickobserver: IClickObserver) :
    IRenderer, IClickable {

    init {
        val clickableRepository: IClickableRepository = ClickableRepository.getInstance()
        clickableRepository.addClickable(this)
    }

    override fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL

        val rect: Rect = Rect()
        rect.left = x
        rect.top = y
        rect.right = x + width
        rect.bottom = y + height
        canvas?.drawRect(rect, paint)

    }

    override val width: Int = 200
    override val height: Int = 200

    override fun onClick() {
        clickobserver.onClick(this)
    }
}