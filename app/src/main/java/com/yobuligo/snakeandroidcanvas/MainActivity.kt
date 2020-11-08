package com.yobuligo.snakeandroidcanvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yobuligo.snakeandroidcanvas.builder.IScreenBuilder
import com.yobuligo.snakeandroidcanvas.builder.ScreenBuilder
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.ElementSize
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.core.Coordinate
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeController
import com.yobuligo.snakeandroidcanvas.ui.view.CanvasView

class MainActivity : AppCompatActivity() {
    private val screenBuilder: IScreenBuilder by lazy { ScreenBuilder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)

        Config.ELEMENT_SIZE = ElementSize.NORMAL.size

        screenBuilder.createMatchFieldBuilder()
            .setPosLeftTop(Coordinate(50, 50))
            .setPosRightBottom(Coordinate(950, 950))
            .build()

        screenBuilder.createSnakeElementSpawnerBuilder()
            .setActiveMultiColor()
            .setAutoSpawnCycleInMilli(1000)
            .setSpawnNumberElementsAtBegin(10)
            .setDeactivateAutoSpawn()
            .build()

        val snake = screenBuilder.createSnakeBuilder()
            //snakeBuilder.startDirection = Direction.LEFT
            .setStartPos(Coordinate(500, 500))
            .setStartNumberElements(8)
            .setMovable(true)
            .setSpeed(Speed.SLOW)
            .build()

        screenBuilder.createDigitalControllerBuilder()
            .setDisplayPauseButton()
            .build(SnakeController(snake))

        setContentView(canvasView)
    }
}
