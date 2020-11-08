package com.yobuligo.snakeandroidcanvas.ui.builder

import com.yobuligo.snakeandroidcanvas.builder.IMatchFieldBuilder
import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.options.ElementSize
import com.yobuligo.snakeandroidcanvas.ui.border.Border
import com.yobuligo.snakeandroidcanvas.ui.core.Coordinate
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate

internal class MatchFieldBuilder : IMatchFieldBuilder {
    private var posLeftTop: ICoordinate = Coordinate(0, 0)
    private var posRightBottom: ICoordinate = Coordinate(800, 800)
    private var noBorders: Boolean = false

    override fun setPosLeftTop(coordinate: ICoordinate): IMatchFieldBuilder {
        posLeftTop = coordinate
        return this
    }

    override fun setPosRightBottom(coordinate: ICoordinate): IMatchFieldBuilder {
        posRightBottom = coordinate
        return this
    }

    override fun setNoBorders(): IMatchFieldBuilder {
        noBorders = true
        return this
    }

    override fun setElementSize(elementSize: ElementSize): IMatchFieldBuilder {
        Config.ELEMENT_SIZE = elementSize.size
        return this
    }

    override fun build() {
        if (noBorders) {
            return
        }

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