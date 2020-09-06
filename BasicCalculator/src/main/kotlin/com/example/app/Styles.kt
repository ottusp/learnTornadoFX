package com.example.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        button {
            prefWidth = 100.px
            prefHeight = 20.px

            minWidth = 50.px

            backgroundColor += c("#eeeeee", .8)
        }
    }
}