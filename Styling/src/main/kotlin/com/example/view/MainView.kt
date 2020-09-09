package com.example.view

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            style {
                fontSize = 40.px
                fontWeight = FontWeight.SEMI_BOLD
                textFill = Color.PINK
                backgroundColor = multi(Color.DARKBLUE)
            }
        }

        button("Hello again") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontSize = 30.px
                backgroundColor = multi(c("pink"))
                borderRadius = multi(box(50.px))
                borderColor = multi(box(Color.BLUE))
                textFill = c("darkblue")
            }
        }
    }
}
