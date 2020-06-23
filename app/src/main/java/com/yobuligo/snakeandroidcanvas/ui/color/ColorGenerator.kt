package com.yobuligo.snakeandroidcanvas.ui.color

import android.graphics.Color
import kotlin.random.Random

class ColorGenerator : IColorGenerator {
    override fun next(): Int {
        when (Random.nextInt(1, 12)) {
            1 -> return Color.RED
            2 -> return Color.GREEN
            3 -> return Color.BLUE
            4 -> return Color.MAGENTA
            5 -> return Color.BLACK
            6 -> return Color.CYAN
            7 -> return Color.DKGRAY
            8 -> return Color.GRAY
            9 -> return Color.LTGRAY
            10 -> return Color.TRANSPARENT
            11 -> return Color.WHITE
            12 -> return Color.YELLOW

        }

        return Color.RED
    }
}