package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.*

class BottomView : View("Bottom View") {
    override val root = hbox {
        alignment = Pos.CENTER
        spacing = 10.0

        label ("This is the bottom")
        button("Oh yes")
    }
}
