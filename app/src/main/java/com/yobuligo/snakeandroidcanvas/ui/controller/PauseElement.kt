package com.yobuligo.snakeandroidcanvas.ui.controller

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import com.yobuligo.snakeandroidcanvas.ui.clickable.ClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickObserver
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickable
import com.yobuligo.snakeandroidcanvas.ui.clickable.IClickableRepository
import com.yobuligo.snakeandroidcanvas.ui.renderer.ICycleAttributes
import com.yobuligo.snakeandroidcanvas.ui.renderer.IRenderer

class PauseElement(override var x: Int, override var y: Int, val clickObserver: IClickObserver) :
    IRenderer, IClickable {

    init {
        val clickableRepository = ClickableRepository.getInstance()
        clickableRepository.addClickable(this)
    }

    override fun render(canvas: Canvas?, cycleAttributes: ICycleAttributes) {
        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL

        var rect: Rect = Rect()
        rect.left = x + 40
        rect.top = y + 40
        rect.right = x + 80
        rect.bottom = y + 160
        canvas?.drawRect(rect, paint)

        rect.left = x + 120
        rect.top = y + 40
        rect.right = x + 160
        rect.bottom = y + 160
        canvas?.drawRect(rect, paint)
    }

    override val width: Int = 200

    override val height: Int = 200

    override fun onClick() {
        clickObserver.onClick(this)
    }

}