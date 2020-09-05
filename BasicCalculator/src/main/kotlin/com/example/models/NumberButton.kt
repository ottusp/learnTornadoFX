package com.example.models

import javafx.event.EventTarget
import javafx.scene.Node
import javafx.scene.control.Button
import tornadofx.*

class NumberButton(number: Int): Button(number.toString()) {

}

fun EventTarget.numberButton(number:Int, graphic: Node? = null, op: NumberButton.() -> Unit = {}) = NumberButton(number).attachTo(this, op) {
    if (graphic != null) it.graphic = graphic
}
