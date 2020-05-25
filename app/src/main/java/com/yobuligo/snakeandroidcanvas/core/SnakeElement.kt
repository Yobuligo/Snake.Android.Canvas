package com.yobuligo.snakeandroidcanvas.core

class SnakeElement(override val predecessor: IMovableElement) : ISnakeElement {
    override var direction: Direction = predecessor.direction
    override var posX: Int = 100
    override var posY: Int = 100
    override var width: Int = posX + Config.ELEMENT_SIZE
        get() = posX + Config.ELEMENT_SIZE
    override var heigth: Int = posY + Config.ELEMENT_SIZE
        get() = posY + Config.ELEMENT_SIZE
}