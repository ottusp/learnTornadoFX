package com.example.app

import com.example.view.MainView
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.Window
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus
import tornadofx.reloadViewsOnFocus

class MyApp: App(MainView::class, Styles::class) {
    init {
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }

    override fun start(stage: Stage) {
        with(stage) {
            width = 800.0
            height = 800.0

            maxHeight = Screen.getPrimary().bounds.height - 40.0
            println("visible width: ${com.sun.glass.ui.Screen.getMainScreen().visibleWidth}")
            println("Y: ${com.sun.glass.ui.Screen.getMainScreen().resolutionY}")
            println("Resolution X: ${com.sun.glass.ui.Screen.getMainScreen().resolutionX}")
        }

        super.start(stage)
    }
}