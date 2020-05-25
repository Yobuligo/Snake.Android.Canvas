package com.yobuligo.snakeandroidcanvas.core

import android.content.Context
import android.hardware.Sensor.TYPE_GAME_ROTATION_VECTOR
import android.hardware.SensorManager
import androidx.core.content.ContextCompat.getSystemService

class Sensor(context: Context) {
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    init {
        //getSystemService(context, SensorManager)
    }

}