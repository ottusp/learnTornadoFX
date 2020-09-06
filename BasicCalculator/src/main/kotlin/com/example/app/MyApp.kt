package com.example.app

import com.example.view.MainView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(MainView::class, Styles::class) {

    override fun start(stage: Stage) {
        with(stage) {
            width = 280.0
            height = 200.0

            maxWidth = 350.0
            minWidth = 200.0
        }

        super.start(stage)
    }
}