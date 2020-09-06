package com.example.view

import com.example.controllers.MainController
import javafx.event.EventTarget
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*

class ButtonMatrixView : View() {

    private val mainController: MainController by inject()

    private fun EventTarget.commaButton(op: Button.() -> Unit = {}) = Button(",").attachTo(this, op)

    private fun HBox.lastLine(): HBox {
        add(numberButton("0"))
        commaButton()
        button("C") {
            action {
                mainController.clearNumbers()
            }
        }

        return this
    }

    private fun numberButton(number: String): Button {

        return button(number) {
            action {
                mainController.addNumberDigit(number)
            }
        }
    }

    private fun HBox.addNumberButtonsLine(range: IntRange): HBox {

        range.map { it.toString() }
                .forEach {
                    this.add(numberButton(it))
                }

        return this
    }

    private fun VBox.addNumberButtonsMatrix(rows: Int, columns: Int): VBox {
        repeat(rows) {
            val first = it * rows + 1
            val last = columns * (it + 1)
            this.add(HBox().addNumberButtonsLine(first..last))
        }
        add(HBox().lastLine())
        return this
    }

    private fun EventTarget.operationButtons(): List<Button> {
        fun opButton(operation: String) = button(operation) {
            action {
                mainController.addOperation(this.text)
            }
        }

        val list = ArrayList<Button>()
        list.add(opButton("+"))
        list.add(opButton("-"))
        list.add(opButton("*"))
        list.add(opButton("/"))

        return list
    }

    private fun EventTarget.operationBox(): VBox {

        return vbox {

            operationButtons().forEach {
                add(it)
            }
        }
    }

    override val root = borderpane {

        center = hbox {
            vbox {
                addNumberButtonsMatrix(3, 3)
            }
            operationBox()
        }
    }


}