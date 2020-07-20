package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement

interface ISnake : IMovableElement {
    var movable: Boolean
    var speed: Speed
    fun hasLastSnakeElement(): Boolean
    fun getLastSnakeElement(): IMovableElement
    fun appendSnakeElement(snakeElement: ISnakeElement)
    fun createAndAppendCollectedSnakeElement(): ISnakeElement
    fun createAndAppendInitialSnakeElement(): ISnakeElement
}