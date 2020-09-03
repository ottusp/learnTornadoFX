package com.example.app

import com.example.view.MainView
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class) {
    override fun start(stage: Stage) {

        with(stage) {
            width = 250.0
            height = 300.0
        }

        super.start(stage)
    }
}