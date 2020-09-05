package com.example.models

import com.example.app.Styles
import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.control.Button
import tornadofx.*

class NumberButton(
        number: String
): Button(number) {
    init {
        addClass(Styles.numberButton)
    }

}

fun EventTarget.numberButton(number:String, graphic: Node? = null, op: NumberButton.() -> Unit = {}) = NumberButton(number).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}
