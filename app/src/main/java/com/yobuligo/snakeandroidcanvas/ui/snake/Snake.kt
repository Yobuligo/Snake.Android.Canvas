package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement

class Snake : ISnake {
    override var direction: Direction = Direction.RIGHT
    override var posX: Int = 0
    override var posY: Int = 0
    override var width: Int = posX + Config.ELEMENT_SIZE
        get() = posX + Config.ELEMENT_SIZE
    override var height: Int = posY + Config.ELEMENT_SIZE
        get() = posY + Config.ELEMENT_SIZE
    override var follower: IMovableElement? = null
    override var predecessor: IMovableElement? = null

    override fun hasLastElement(): Boolean {
        return follower != null
    }

    override fun getLastElement(): IMovableElement? {
        if (!hasLastElement()) {
            return null
        }

        var lastElement = follower
        while (true) {
            if (lastElement?.follower == null) {
                return lastElement
            }

            lastElement = lastElement?.follower
        }
    }
}