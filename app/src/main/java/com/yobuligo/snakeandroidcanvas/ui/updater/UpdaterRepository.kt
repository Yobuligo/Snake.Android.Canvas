package com.yobuligo.snakeandroidcanvas.ui.updater

class UpdaterRepository : IUpdaterRepository {
    private val updaterList: MutableList<IUpdater> = mutableListOf<IUpdater>()

    override fun addUpdater(updater: IUpdater) {
        updaterList.add(updater)
    }

    override fun getUpdater(): List<IUpdater> {
        return updaterList
    }
}