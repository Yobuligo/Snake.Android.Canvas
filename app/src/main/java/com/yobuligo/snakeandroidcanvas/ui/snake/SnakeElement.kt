package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.core.Element
import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement

class SnakeElement(override var predecessor: IMovableElement?) : Element(), ISnakeElement {
    override var direction: Direction = predecessor?.direction ?: Direction.RIGHT
    override var follower: IMovableElement? = null
}