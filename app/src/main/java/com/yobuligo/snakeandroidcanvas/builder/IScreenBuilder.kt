package com.yobuligo.snakeandroidcanvas.builder

/**
 * Builder that is responsible for building the  whole screen of the game
 */
interface IScreenBuilder {
    /**
     * Creates a digital controller builder which is responsible for building a controller to control the direction of the snake
     */
    fun createDigitalControllerBuilder(): IDigitalControllerBuilder

    /**
     * Creates a match field builder which is responsible for building the field for the snake, inclusive borders
     */
    fun createMatchFieldBuilder(): IMatchFieldBuilder

    /**
     * Creates a snake builder which is responsible for building a snake
     */
    fun createSnakeBuilder(): ISnakeBuilder

    /**
     * Creates a snake element spawner builder which is responsible for building a snake element spawner. A snake element spawner controls when and how to spawn new snake elements
     */
    fun createSnakeElementSpawnerBuilder(): ISnakeElementSpawnerBuilder
}