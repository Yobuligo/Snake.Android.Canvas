package com.yobuligo.snakeandroidcanvas.ui.snake

import android.graphics.Color
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.element.Element
import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement

class Snake : Element(), ISnake {
    override var direction: Direction = Direction.RIGHT
    override var follower: IMovableElement? = null
    override var predecessor: IMovableElement? = null
    override var color: Int = Color.BLUE
    override var movable: Boolean = true
    override var speed: Speed = Speed.MIDDLE

    init {
        val snakeRepository: ISnakeRepository = SnakeRepository.getInstance()
        snakeRepository.addSnake(this)
    }

    override fun hasLastSnakeElement(): Boolean {
        return follower != null
    }

    override fun getLastSnakeElement(): IMovableElement {
        if (!hasLastSnakeElement()) {
            return this
        }

        var lastElement = follower
        while (true) {
            if (lastElement?.follower == null) {
                return lastElement!!
            }

            lastElement = lastElement?.follower
        }
    }

    override fun appendSnakeElement(snakeElement: ISnakeElement) {
        val lastElement = getLastSnakeElement()
        putMovableRelationship(lastElement, snakeElement)
    }

    override fun createAndAppendCollectedSnakeElement(): ISnakeElement {
        val lastElement = getLastSnakeElement()
        val snakeElement = SnakeElement(lastElement)
        putMovableRelationship(lastElement, snakeElement)
        snakeElement.pos.x = lastElement.pos.x
        snakeElement.pos.y = lastElement.pos.y
        return snakeElement
    }

    override fun createAndAppendInitialSnakeElement(): ISnakeElement {
        val lastElement = getLastSnakeElement()
        val snakeElement = SnakeElement(lastElement)
        putMovableRelationship(lastElement, snakeElement)
        putCoordinatesRelationship(lastElement, snakeElement)
        return snakeElement
    }

    private fun putMovableRelationship(
        predecessor: IMovableElement,
        follower: IMovableElement
    ) {
        follower.direction = predecessor.direction
        follower.predecessor = predecessor
        predecessor?.follower = follower
    }

    private fun putCoordinatesRelationship(
        predecessor: IMovableElement,
        follower: IMovableElement
    ) {
        when (predecessor.direction) {
            Direction.UP -> {
                follower.pos.x = predecessor.pos.x
                follower.pos.y = predecessor.pos.y + Config.ELEMENT_SIZE
            }
            Direction.DOWN -> {
                follower.pos.x = predecessor.pos.x
                follower.pos.y = predecessor.pos.y - Config.ELEMENT_SIZE
            }
            Direction.LEFT -> {
                follower.pos.x = predecessor.pos.x + Config.ELEMENT_SIZE
                follower.pos.y = predecessor.pos.y
            }
            Direction.RIGHT -> {
                follower.pos.x = predecessor.pos.x - Config.ELEMENT_SIZE
                follower.pos.y = predecessor.pos.y
            }
        }
    }
}