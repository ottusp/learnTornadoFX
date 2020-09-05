package com.example.view

import com.example.models.NumberButton
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*

class ButtonMatrixView : View("My View") {

    private fun HBox.addNumberButtonsLine(range: IntRange): HBox {
        range.forEach {
            this.add(NumberButton(it))
        }

        return this
    }

    private fun VBox.addNumberButtonsMatrix(rows: Int, columns: Int): VBox {
        repeat(rows) {
            val first = it * rows + 1
            val last = columns * (it + 1)
            this.add(HBox().addNumberButtonsLine(first..last))
        }
        return this
    }

    override val root = vbox {
        addNumberButtonsMatrix(3, 3)
    }
}
