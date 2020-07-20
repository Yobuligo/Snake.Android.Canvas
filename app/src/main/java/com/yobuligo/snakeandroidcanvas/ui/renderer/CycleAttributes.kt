package com.yobuligo.snakeandroidcanvas.ui.renderer

class CycleAttributes(
    override val currentTimeinMilli: Long,
    override val lastTimeInMilli: Long,
    override val elapsedTimeinMilli: Long
) : ICycleAttributes {
}