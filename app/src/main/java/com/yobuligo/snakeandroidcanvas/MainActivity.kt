package com.yobuligo.snakeandroidcanvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yobuligo.snakeandroidcanvas.builder.*
import com.yobuligo.snakeandroidcanvas.builder.SnakeBuilder
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.ElementSize
import com.yobuligo.snakeandroidcanvas.options.Speed
import com.yobuligo.snakeandroidcanvas.ui.controller.DigitalController
import com.yobuligo.snakeandroidcanvas.ui.controller.IDigitalController
import com.yobuligo.snakeandroidcanvas.ui.renderer.ElementRenderer
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.snake.SnakeController
import com.yobuligo.snakeandroidcanvas.ui.view.CanvasView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)

        Config.ELEMENT_SIZE = ElementSize.NORMAL.size
        Config.SPEED = Speed.SLOW

        val frameBuilder = FrameBuilder()
        frameBuilder.setPosLeftTop(Coordinate(50, 50))
        frameBuilder.setPosRightBottom(Coordinate(950, 950))
        frameBuilder.build()

        val snakeElementSpawnerBuilder = SnakeElementSpawnerBuilder()
        snakeElementSpawnerBuilder.setAutoSpawnCycleInMilli(1000)
        snakeElementSpawnerBuilder.setActiveMultiColor()
        canvasView.addUpdater(snakeElementSpawnerBuilder.build())

        val snake: ISnake = buildSnake()
        canvasView.addRenderer(ElementRenderer(snake))

        val digitalControllerBuilder: IDigitalControllerBuilder = DigitalControllerBuilder()
        val digitalController = digitalControllerBuilder.build(SnakeController(snake))
        canvasView.addRenderer(digitalController)

        setContentView(canvasView)
    }

    private fun buildSnake(): ISnake {
        val snakeBuilder = SnakeBuilder()
        //snakeBuilder.startDirection = Direction.LEFT
        snakeBuilder.startPos = Coordinate(500, 500)
        snakeBuilder.startNumberElements = 10
        snakeBuilder.movable = true
        return snakeBuilder.build()
    }
}
