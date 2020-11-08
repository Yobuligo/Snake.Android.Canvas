package com.yobuligo.snakeandroidcanvas.ui.renderer

import junit.framework.TestCase

class SnakeRendererRepositoryTest : TestCase() {

    fun testAddRenderer() {
        val rendererRepository = RendererRepository.instance
        assertNotNull(rendererRepository)
    }

    fun testGetRenderer() {}
}