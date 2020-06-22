package com.yobuligo.snakeandroidcanvas.ui.clickable

interface IClickableRepository {
    fun addClickable(clickable: IClickable)
    fun getClickables(): List<IClickable>
    fun onClick(clickedPosX: Int, clickedPosY: Int)
}