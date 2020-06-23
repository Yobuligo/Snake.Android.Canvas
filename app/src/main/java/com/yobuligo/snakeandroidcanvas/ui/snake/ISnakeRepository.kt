package com.yobuligo.snakeandroidcanvas.ui.snake

interface ISnakeRepository {
    fun addSnake(snake: ISnake)
    fun getSnakes(): List<ISnake>
}