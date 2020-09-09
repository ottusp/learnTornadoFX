package com.example.app

import com.example.view.MainView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(MainView::class, Styles::class) {

    init {
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }

    override fun start(stage: Stage) {
        with(stage) {
            width = 1200.0
            height = 600.0
        }

        super.start(stage)
    }
}