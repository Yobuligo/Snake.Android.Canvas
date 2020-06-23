package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Color
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.element.Element
import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement

class SnakeElement(override var predecessor: IMovableElement?) : Element(), ISnakeElement {
    override var direction: Direction = predecessor?.direction ?: Direction.RIGHT
    override var follower: IMovableElement? = null
    override var color: Int = Color.RED
}