package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.ui.core.IMovableElement

interface ISnake : IMovableElement {
    fun hasLastElement(): Boolean
    fun getLastElement(): IMovableElement?
}