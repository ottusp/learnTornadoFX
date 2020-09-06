package com.example.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val resultBox by cssclass()
        val textfield by cssclass()
        val comboBox by cssclass()

        private val coolStyle = CssSelectionBlock {
            backgroundRadius = multi(box(20.px))
            backgroundColor = multi(c("#303030"))

            textFill = Color.WHITE
            fontWeight = FontWeight.BOLD
        }

    }

    init {
        resultBox{
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            fontFamily = "Comic Sans MS"
            backgroundColor = multi(c("#f77fbe"))
        }

        textfield {
            mix(coolStyle)

        }

        comboBox {
            mix(coolStyle)
            backgroundColor = multi(c("808080"))
        }
    }
}