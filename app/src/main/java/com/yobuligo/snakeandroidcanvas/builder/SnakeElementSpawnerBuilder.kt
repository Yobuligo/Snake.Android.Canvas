package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawner
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeElementSpawner

class SnakeElementSpawnerBuilder : ISnakeElementSpawnerBuilder {
    private var autoSpawnCycleInMilli: Long = 0.toLong()
    private var isMultiColor: Boolean = false
    private var spawnNumberElements: Int = 0
    private var deactivateAutoSpawn: Boolean = false

    override fun setAutoSpawnCycleInMilli(autoSpawnCycleInMilli: Long): ISnakeElementSpawnerBuilder {
        this.autoSpawnCycleInMilli = autoSpawnCycleInMilli
        return this
    }

    override fun setActiveMultiColor(): ISnakeElementSpawnerBuilder {
        isMultiColor = true
        return this
    }

    override fun setSpawnNumberElementsAtBegin(spawnNumberElements: Int): ISnakeElementSpawnerBuilder {
        this.spawnNumberElements = spawnNumberElements
        return this
    }

    override fun setDeactivateAutoSpawn(): ISnakeElementSpawnerBuilder {
        deactivateAutoSpawn = true
        return this
    }

    override fun build(): ISnakeElementSpawner {
        val snakeElementSpawner = SnakeElementSpawner(autoSpawnCycleInMilli, isMultiColor, deactivateAutoSpawn)
        if (spawnNumberElements > 0) {
            for (i in 1..spawnNumberElements) {
                snakeElementSpawner.spawnElement()
            }
        }
        return snakeElementSpawner
    }
}