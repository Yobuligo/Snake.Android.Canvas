package com.yobuligo.snakeandroidcanvas.ui.updater

class UpdaterRepository private constructor() : IUpdaterRepository {
    private val updaterList: MutableList<IUpdater> = mutableListOf<IUpdater>()

    private object Singleton {
        val INSTANCE = UpdaterRepository()
    }

    companion object {
        val instance by lazy { Singleton.INSTANCE }
    }

    override fun addUpdater(updater: IUpdater) {
        updaterList.add(updater)
    }

    override fun getUpdater(): List<IUpdater> {
        return updaterList
    }
}