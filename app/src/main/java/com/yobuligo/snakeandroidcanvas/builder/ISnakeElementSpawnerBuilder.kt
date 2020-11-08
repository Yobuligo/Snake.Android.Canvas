package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawner

/**
 * Builder that is responsible for building the snake element spawner.
 * The snake element spawner controls how and when to spawn snake elements to be collected.
 */
interface ISnakeElementSpawnerBuilder {
    fun setAutoSpawnCycleInMilli(autoSpawnCycleInMilli: Long): ISnakeElementSpawnerBuilder
    fun setActiveMultiColor(): ISnakeElementSpawnerBuilder
    fun setSpawnNumberElementsAtBegin(spawnNumberElements: Int): ISnakeElementSpawnerBuilder
    fun setDeactivateAutoSpawn(): ISnakeElementSpawnerBuilder
    fun build(): ISnakeElementSpawner
}