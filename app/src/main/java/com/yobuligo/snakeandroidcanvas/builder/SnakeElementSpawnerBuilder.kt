package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.snake.ISnakeElementSpawner
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeElementSpawner

class SnakeElementSpawnerBuilder : ISnakeElementSpawnerBuilder {
    private var autoSpawnCycleInMilli: Long = 0.toLong()
    private var isMultiColor: Boolean = false

    override fun setAutoSpawnCycleInMilli(autoSpawnCycleInMilli: Long) {
        this.autoSpawnCycleInMilli = autoSpawnCycleInMilli
    }

    override fun setActiveMultiColor() {
        isMultiColor = true
    }

    override fun build(): ISnakeElementSpawner {
        return SnakeElementSpawner(autoSpawnCycleInMilli, isMultiColor)
    }
}