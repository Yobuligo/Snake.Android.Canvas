package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.ui.element.IMovableElement

interface ISnake : IMovableElement {
    var movable: Boolean
    fun hasLastElement(): Boolean
    fun getLastElement(): IMovableElement?
}