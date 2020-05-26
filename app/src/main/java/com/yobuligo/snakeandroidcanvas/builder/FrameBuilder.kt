package com.yobuligo.snakeandroidcanvas.builder

class FrameBuilder : IFrameBuilder {
    private var posLeftTop: ICoordinate = Coordinate(0, 0)
    private var posLeftBottom: ICoordinate = Coordinate(0, 800)
    private var posRightTop: ICoordinate = Coordinate(800, 0)
    private var posRightBottom: ICoordinate = Coordinate(800, 800)

    override fun setPosLeftTop(posLeftTop: ICoordinate) {
        this.posLeftTop = posLeftTop
    }

    override fun setPosLeftBottom(posLeftBottom: ICoordinate) {
        this.posLeftBottom = posLeftBottom
    }

    override fun setPosRightTop(posRightTop: ICoordinate) {
        this.posRightTop = posRightTop
    }

    override fun setPosRightBottom(posRightBottom: ICoordinate) {
        this.posRightBottom = posRightBottom
    }

    override fun build() {
        TODO("Not yet implemented")
    }

}