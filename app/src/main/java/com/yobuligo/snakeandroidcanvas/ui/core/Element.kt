package com.yobuligo.snakeandroidcanvas.ui.core

import com.yobuligo.snakeandroidcanvas.options.Config

open class Element : IElement {
    override var posX: Int = 0
    override var posY: Int = 0
    override var width: Int = posX + Config.ELEMENT_SIZE
        get() = posX + Config.ELEMENT_SIZE
    override var height: Int = posY + Config.ELEMENT_SIZE
        get() = posY + Config.ELEMENT_SIZE
}