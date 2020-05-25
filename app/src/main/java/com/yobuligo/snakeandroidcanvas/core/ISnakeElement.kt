package com.yobuligo.snakeandroidcanvas.core

interface ISnakeElement : IMovableElement {
    val predecessor: IMovableElement
}