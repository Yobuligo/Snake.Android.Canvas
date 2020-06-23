package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawner

interface ISnakeElementSpawnerBuilder {
    fun setAutoSpawnCycleInMilli(autoSpawnCycleInMilli: Long): ISnakeElementSpawnerBuilder
    fun setActiveMultiColor(): ISnakeElementSpawnerBuilder
    fun build(): ISnakeElementSpawner
}