package com.yobuligo.snakeandroidcanvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yobuligo.snakeandroidcanvas.core.IMovableElement
import com.yobuligo.snakeandroidcanvas.core.Snake
import com.yobuligo.snakeandroidcanvas.core.SnakeElement
import com.yobuligo.snakeandroidcanvas.renderer.Renderer
import com.yobuligo.snakeandroidcanvas.snake.model.ISnake

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val canvasView = CanvasView(this)

        val posY: Int = -2000

        //initialize Snake
        val snake: ISnake = Snake()
        canvasView.renderer = Renderer()
        canvasView.snake = snake
        snake.posX = 700
        snake.posY = posY
        var predecessor = snake as IMovableElement
        canvasView.renderer.elements.add(snake)
        for (count in 5 downTo 0) {
            val movableElement: IMovableElement = SnakeElement(predecessor)
            movableElement.posX = 100 + (count * 100)
            movableElement.posY = posY
            canvasView.renderer.elements.add(movableElement)
            predecessor = movableElement
        }

        setContentView(canvasView)
    }

}
