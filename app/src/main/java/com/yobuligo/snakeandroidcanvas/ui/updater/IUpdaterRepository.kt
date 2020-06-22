package com.yobuligo.snakeandroidcanvas.ui.updater

interface IUpdaterRepository {
    fun addUpdater(updater: IUpdater)
    fun getUpdater(): List<IUpdater>
}