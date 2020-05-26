package com.yobuligo.snakeandroidcanvas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yobuligo.snakeandroidcanvas.options.Direction
import com.yobuligo.snakeandroidcanvas.ui.snake.ISnake
import com.yobuligo.snakeandroidcanvas.ui.renderer.Renderer
import com.yobuligo.snakeandroidcanvas.builder.SnakeBuilder
import com.yobuligo.snakeandroidcanvas.ui.view.CanvasView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)
        canvasView.addRenderer(Renderer(buildSnake()))
        canvasView.addRenderer(Renderer(buildSnake2()))
        setContentView(canvasView)
    }

    private fun buildSnake(): ISnake {
        val snakeBuilder = SnakeBuilder()
        snakeBuilder.setStartDirection(Direction.LEFT)
        snakeBuilder.setStartPosX(500)
        snakeBuilder.setStartPosY(500)
        snakeBuilder.setStartNumberElements(6)
        return snakeBuilder.build()
    }

    private fun buildSnake2(): ISnake {
        val snakeBuilder = SnakeBuilder()
        snakeBuilder.setStartDirection(Direction.RIGHT)
        snakeBuilder.setStartPosX(500)
        snakeBuilder.setStartPosY(300)
        snakeBuilder.setStartNumberElements(6)
        return snakeBuilder.build()
    }
}
