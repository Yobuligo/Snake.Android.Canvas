package com.yobuligo.snakeandroidcanvas.ui.playfield

import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate

interface IPlayfieldAdministrator {
    fun getNextFreeRandomCoordinate(): ICoordinate
}