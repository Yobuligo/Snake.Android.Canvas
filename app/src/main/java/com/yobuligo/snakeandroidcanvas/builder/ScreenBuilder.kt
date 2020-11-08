package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.ui.builder.DigitalControllerBuilder
import com.yobuligo.snakeandroidcanvas.ui.builder.MatchFieldBuilder
import com.yobuligo.snakeandroidcanvas.ui.builder.SnakeBuilder
import com.yobuligo.snakeandroidcanvas.ui.builder.SnakeElementSpawnerBuilder

/**
 * Builder to provide others builders for designing the whole screen of the game
 */
class ScreenBuilder : IScreenBuilder {
    private val digitalControllerBuilder: IDigitalControllerBuilder by lazy { DigitalControllerBuilder() }
    private val matchFieldBuilder: IMatchFieldBuilder by lazy { MatchFieldBuilder() }
    private val snakeBuilder: ISnakeBuilder by lazy { SnakeBuilder() }
    private val snakeElementSpawnerBuilder: ISnakeElementSpawnerBuilder by lazy { SnakeElementSpawnerBuilder() }

    override fun createDigitalControllerBuilder(): IDigitalControllerBuilder {
        return digitalControllerBuilder
    }

    override fun createMatchFieldBuilder(): IMatchFieldBuilder {
        return matchFieldBuilder
    }

    override fun createSnakeBuilder(): ISnakeBuilder {
        return snakeBuilder
    }

    override fun createSnakeElementSpawnerBuilder(): ISnakeElementSpawnerBuilder {
        return snakeElementSpawnerBuilder
    }
}