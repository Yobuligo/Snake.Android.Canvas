package com.yobuligo.snakeandroidcanvas.ui.element

import com.yobuligo.snakeandroidcanvas.options.Direction

interface IMovableElement : IElement {
    var direction: Direction
    var follower: IMovableElement?
    var predecessor: IMovableElement?
}