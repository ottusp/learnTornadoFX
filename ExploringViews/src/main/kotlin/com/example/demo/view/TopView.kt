package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.*

class TopView : View("My View") {
    override val root = hbox {

        alignment = Pos.CENTER
        spacing = 10.0

        label("My top view")
        button ("Menu")
        button ("File")

    }
}
