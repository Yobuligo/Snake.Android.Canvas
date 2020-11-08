package com.yobuligo.snakeandroidcanvas.ui.playfield

import com.yobuligo.snakeandroidcanvas.options.Config
import com.yobuligo.snakeandroidcanvas.ui.collision.CollisionDetector
import com.yobuligo.snakeandroidcanvas.ui.core.Coordinate
import com.yobuligo.snakeandroidcanvas.ui.core.ICoordinate
import kotlin.random.Random

class PlayfieldAdministrator : IPlayfieldAdministrator {
    companion object {
        val instance: IPlayfieldAdministrator by lazy<IPlayfieldAdministrator> {
            PlayfieldAdministrator()
        }
    }

    override fun getNextFreeRandomCoordinate(): ICoordinate {
        //Todo: Replace 800 by Gamefield Size
        val numberElementsX = 950 / Config.ELEMENT_SIZE
        val numberElementsY = 950 / Config.ELEMENT_SIZE

        //Todo: Consider that there is no more free space
        while (true) {
            val coordinate = Coordinate(
                Random.nextInt(2, numberElementsX) * Config.ELEMENT_SIZE,
                Random.nextInt(2, numberElementsY) * Config.ELEMENT_SIZE
            )
            if (CollisionDetector.instance.isCoordinateOccupied(coordinate).not()) {
                return coordinate
            }
        }
    }
}