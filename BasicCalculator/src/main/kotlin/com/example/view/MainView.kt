package com.example.view

import com.example.app.Styles
import com.example.controllers.MainController
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    private val mainController: MainController by inject()

    override val root = vbox {
        label(mainController.result) {
            addClass(Styles.heading)
        }
    }
}
