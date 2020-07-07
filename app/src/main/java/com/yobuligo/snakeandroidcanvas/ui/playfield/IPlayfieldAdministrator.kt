package com.yobuligo.snakeandroidcanvas.ui.playfield

import com.yobuligo.snakeandroidcanvas.builder.ICoordinate

interface IPlayfieldAdministrator {
    fun getNextFreeRandomCoordinate(): ICoordinate
}