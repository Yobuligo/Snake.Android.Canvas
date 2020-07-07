package com.yobuligo.snakeandroidcanvas.ui.snake

import com.yobuligo.snakeandroidcanvas.ui.updater.IUpdater

interface ISnakeElementSpawner : IUpdater {
    fun spawnElement(): ISnakeElementSpawn
}