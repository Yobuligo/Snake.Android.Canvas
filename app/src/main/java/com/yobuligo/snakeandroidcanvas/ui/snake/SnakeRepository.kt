package com.yobuligo.snakeandroidcanvas.ui.snake

class SnakeRepository : ISnakeRepository {
    private val snakeList: MutableList<ISnake> = mutableListOf<ISnake>()

    companion object {
        private val instance: ISnakeRepository = SnakeRepository()

        fun getInstance(): ISnakeRepository {
            return instance
        }
    }

    override fun addSnake(snake: ISnake) {
        snakeList.add(snake)
    }

    override fun getSnakes(): List<ISnake> {
        return snakeList
    }
}