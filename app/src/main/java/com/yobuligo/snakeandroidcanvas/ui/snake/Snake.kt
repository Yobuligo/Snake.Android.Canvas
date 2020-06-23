package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Color
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.element.Element
import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement

class Snake : Element(), ISnake {
    override var direction: Direction = Direction.RIGHT
    override var follower: IMovableElement? = null
    override var predecessor: IMovableElement? = null
    override var color: Int = Color.BLUE
    override var movable: Boolean = true

    init {
        val snakeRepository: ISnakeRepository = SnakeRepository.getInstance()
        snakeRepository.addSnake(this)
    }

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