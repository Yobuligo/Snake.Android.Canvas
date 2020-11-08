package com.yobuligo.snakeandroidcanvas.builder

/**
 * Builder that is responsible for building the  whole screen of the game
 */
interface IScreenBuilder {
    fun createDigitalControllerBuilder(): IDigitalControllerBuilder
    fun createMatchFieldBuilder(): IMatchFieldBuilder
    fun createSnakeBuilder(): ISnakeBuilder
    fun createSnakeElementSpawnerBuilder(): ISnakeElementSpawnerBuilder
}