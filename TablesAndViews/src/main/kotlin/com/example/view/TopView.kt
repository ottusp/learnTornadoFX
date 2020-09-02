package com.example.view

import com.example.controllers.MainController
import tornadofx.*

class TopView : View("My View") {

    private val mainController: MainController by inject()

    override val root = vbox {
        prefHeight = 250.0

        listview(mainController.names) {
            cellFormat {
                text = it
                if (text.contains("ic")) {
                    textFill = c("green", 1.0)
                    style {
                        fontSize = 20.px
                    }
                }
            }
        }
    }
}
