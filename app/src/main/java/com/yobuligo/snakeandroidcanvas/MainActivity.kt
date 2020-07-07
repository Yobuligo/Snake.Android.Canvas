package com.yobuligo.snakeandroidcanvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yobuligo.snakeandroidcanvas.builder.*
import com.yobuligo.snakeandroidcanvas.builder.SnakeBuilder
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.ElementSize
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.renderer.ElementRenderer
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeController
import com.yobuligo.snakeandroidcanvas.ui.view.CanvasView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)

        Config.ELEMENT_SIZE = ElementSize.NORMAL.size
        Config.SPEED = Speed.SUPERFAST

        val snake: ISnake = buildSnake()
        canvasView.addRenderer(ElementRenderer(snake))

        FrameBuilder()
            .setPosLeftTop(Coordinate(50, 50))
            .setPosRightBottom(Coordinate(950, 950))
            .build()

        canvasView.addUpdater(
            SnakeElementSpawnerBuilder()
                .setActiveMultiColor()
                .setAutoSpawnCycleInMilli(0)
                .setSpawnNumberElementsAtBegin(20)
                .build()
        )

        canvasView.addRenderer(
            DigitalControllerBuilder()
                .setDisplayPauseButton()
                .build(SnakeController(snake))
        )

        setContentView(canvasView)
    }

    private fun buildSnake(): ISnake {
        return SnakeBuilder()
            //snakeBuilder.startDirection = Direction.LEFT
            .setStartPos(Coordinate(500, 500))
            .setStartNumberElements(8)
            .setMovable(true)
            .build()
    }
}
