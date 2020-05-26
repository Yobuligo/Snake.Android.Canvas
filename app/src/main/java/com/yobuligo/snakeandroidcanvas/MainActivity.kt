package com.yobuligo.snakeandroidcanvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yobuligo.snakeandroidcanvas.builder.Coordinate
import com.yobuligo.snakeandroidcanvas.builder.FrameBuilder
import com.yobuligo.snakeandroidcanvas.builder.IFrameBuilder
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.renderer.Renderer
import com.yobuligo.snakeandroidcanvas.builder.SnakeBuilder
import com.yobuligo.snakeandroidcanvas.ui.border.Border
import com.yobuligo.snakeandroidcanvas.ui.view.CanvasView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)

        val frameBuilder = FrameBuilder()
        frameBuilder.posLeftTop = Coordinate(50, 50)
        frameBuilder.posRightBottom = Coordinate(950, 950)
        frameBuilder.build()

        canvasView.addRenderer(Renderer(buildSnake()))
        setContentView(canvasView)
    }

    private fun buildSnake(): ISnake {
        val snakeBuilder = SnakeBuilder()
        snakeBuilder.startDirection = Direction.LEFT
        snakeBuilder.startPos = Coordinate(500, 500)
        snakeBuilder.startNumberElements = 0
        snakeBuilder.movable = true
        return snakeBuilder.build()
    }
}
