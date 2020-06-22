package com.yobuligo.snakeandroidcanvas.ui.clickable

class ClickableRepository() : IClickableRepository {
    private val clickables = mutableListOf<IClickable>()

    companion object {
        private val instance = ClickableRepository()
        fun getInstance(): IClickableRepository {
            return instance
        }
    }

    override fun addClickable(clickable: IClickable) {
        clickables.add(clickable)
    }

    override fun getClickables(): List<IClickable> {
        return clickables
    }

    override fun onClick(clickedPosX: Int, clickedPosY: Int) {
        for (clickable in clickables) {
            val minX = clickable.x
            val maxX = clickable.x + clickable.width
            val minY = clickable.y
            val maxY = clickable.y + clickable.height
            if (clickedPosX >= minX && clickedPosX <= maxX && clickedPosY >= minY && clickedPosY <= maxY) {
                clickable.onClick()
            }
        }
    }
}