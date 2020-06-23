package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawner

interface ISnakeElementSpawnerBuilder {
    fun setAutoSpawnCycleInMilli(autoSpawnCycleInMilli: Long)
    fun setActiveMultiColor()
    fun build(): ISnakeElementSpawner
}