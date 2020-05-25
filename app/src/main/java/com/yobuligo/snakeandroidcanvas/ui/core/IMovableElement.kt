package com.yobuligo.snakeandroidcanvas.ui.core

import com.yobuligo.snakeandroidcanvas.core.Direction

interface IMovableElement :
    IElement {
    var direction: Direction
    var follower: IMovableElement?
    var predecessor: IMovableElement?
}