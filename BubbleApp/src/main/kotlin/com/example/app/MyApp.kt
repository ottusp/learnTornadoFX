package com.example.app

import com.example.view.MainView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus
import tornadofx.reloadViewsOnFocus

class MyApp: App(MainView::class, Styles::class) {

    init {
        reloadStylesheetsOnFocus()
        reloadViewsOnFocus()
    }

}