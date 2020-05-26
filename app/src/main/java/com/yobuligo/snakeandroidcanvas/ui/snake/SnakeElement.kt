package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement

class SnakeElement(override var predecessor: IMovableElement?) : ISnakeElement {
    override var direction: Direction = predecessor?.direction ?: Direction.RIGHT
    override var posX: Int = 100
    override var posY: Int = 100
    override var width: Int = posX + Config.ELEMENT_SIZE
        get() = posX + Config.ELEMENT_SIZE
    override var height: Int = posY + Config.ELEMENT_SIZE
        get() = posY + Config.ELEMENT_SIZE
    override var follower: IMovableElement? = null
}