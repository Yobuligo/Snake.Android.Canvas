package com.yobuligo.snakeandroidcanvas.core

import com.yobuligo.snakeandroidcanvas.snake.model.ISnake

class Snake : ISnake {
    override var direction: Direction = Direction.RIGHT
    override var posX: Int = 0
    override var posY: Int = 0
    override var width: Int = posX + Config.ELEMENT_SIZE
        get() = posX + Config.ELEMENT_SIZE
    override var heigth: Int = posY + Config.ELEMENT_SIZE
        get() = posY + Config.ELEMENT_SIZE
}