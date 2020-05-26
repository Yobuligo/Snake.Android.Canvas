package com.yobuligo.snakeandroidcanvas.builder

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.ui.border.Border

class FrameBuilder : IFrameBuilder {
    override var posLeftTop: ICoordinate = Coordinate(0, 0)
    override var posRightBottom: ICoordinate = Coordinate(800, 800)

    override fun build() {
        val numberElementsHorizontal: Int =
            posRightBottom.x.minus(posLeftTop.x).div(Config.ELEMENT_SIZE)
        val numberElementsVertical: Int =
            posRightBottom.y.minus(posLeftTop.y).div(Config.ELEMENT_SIZE)

        for (number in 0..numberElementsHorizontal) {
            var border = Border()
            border.pos =
                Coordinate(number.times(Config.ELEMENT_SIZE) + posLeftTop.x, posLeftTop.y)
            border = Border()
            border.pos =
                Coordinate(number.times(Config.ELEMENT_SIZE) + posLeftTop.x, posRightBottom.y)
        }

        for (number in 0..numberElementsVertical) {
            var border = Border()
            border.pos =
                Coordinate(posLeftTop.x, number.times(Config.ELEMENT_SIZE) + posLeftTop.y)
            border = Border()
            border.pos =
                Coordinate(posRightBottom.x, number.times(Config.ELEMENT_SIZE) + posLeftTop.y)
        }
    }
}