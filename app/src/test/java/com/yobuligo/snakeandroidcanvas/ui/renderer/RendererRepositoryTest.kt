package com.yobuligo.snakeandroidcanvas.ui.renderer

import junit.framework.TestCase

class RendererRepositoryTest : TestCase() {

    fun testAddRenderer() {
        val rendererRepository = RendererRepository()
        assertNotNull(rendererRepository)
    }

    fun testGetRenderer() {}
}