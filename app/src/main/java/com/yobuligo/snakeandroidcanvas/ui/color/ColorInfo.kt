package com.yobuligo.snakeandroidcanvas.ui.color

import android.graphics.Color

class ColorInfo : IColorInfo {
    override fun colorCodeToText(color: Int): String {
        when (color) {
            Color.RED -> return "Red"
            Color.GREEN -> return "Green"
            Color.BLUE -> return "Blue"
            Color.MAGENTA -> return "Magenta"
            Color.BLACK -> return "Black"
            Color.CYAN -> return "Cyan"
            Color.DKGRAY -> return "Darkgray"
            Color.GRAY -> return "Gray"
            Color.LTGRAY -> return "Lightgray"
            Color.TRANSPARENT -> return "Transparent"
            Color.WHITE -> return "White"
            Color.YELLOW -> return "Yellow"
        }

        return "Unknown Color"
    }
}