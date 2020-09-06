package com.example.view

import com.example.app.Styles
import com.example.controllers.MainController
import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.control.ComboBox
import javafx.scene.control.Slider
import javafx.scene.control.TextField
import javafx.scene.input.KeyCode
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("Bill Splitter") {

    private val mainController: MainController by inject()

    private var splitCombo: ComboBox<Int> by singleAssign()
    private var mSlider: Slider by singleAssign()
    private var billAmountField: TextField by singleAssign()

    private val oneToTen = mutableListOf<Int>()
    init {
        for(i in 1..10)
            oneToTen.add(i)
    }

    override val root = vbox {
        alignment = Pos.TOP_CENTER

        vbox {
            alignment = Pos.TOP_CENTER
            addClass(Styles.resultBox)

            label("Total Per Person") {
                style {
                    textFill = c("#303030")
                }
            }
            label {
                style {
                    textFill = c("#4c454c")
                }

                textProperty().bind(Bindings.concat(
                        Bindings.format("%.2f", mainController.totalPerPerson)
                ))
            }
        }

        form {

            fieldset(labelPosition =  Orientation.HORIZONTAL) {
                field("Bill Amount") {
                    maxWidth = 190.0
                    billAmountField = textfield {
                        addClass(Styles.textfield)

                        filterInput {
                            it.controlNewText.isDouble() || it.controlNewText.isInt()
                        }

                        setOnKeyPressed {
                            if(it.code == KeyCode.ENTER) {
                                validateField()
                            }
                        }
                    }

                }

                field {
                    label("Split by: ")
                    splitCombo = combobox(values = oneToTen) {
                        addClass(Styles.comboBox)

                        prefWidth = 135.0
                        value = oneToTen.first()

                        valueProperty().onChange {
                            validateField()
                        }
                    }

                }

                field {
                    hbox {
                        spacing = 23.0

                        label("Total tip")
                        label {

                            textProperty().bind(Bindings.concat("$",
                                    mainController.tipPercentageAmount
                            ))
                        }
                    }
                }

                field {
                    hbox {
                        label("Tip %")
                        mSlider = slider(min = 0, max = 100,
                            orientation = Orientation.HORIZONTAL)
                        mSlider.valueProperty().onChange {
                            validateField()
                        }
                        label().textProperty().bind(Bindings.concat(
                                mainController.sliderPercentageAmount, "%"
                        ))
                    }
                }
            }
        }
    }

    private fun validateField() {
        if (billAmountField.text.toString().isNotEmpty()) {
            mainController.calculate(
                    SimpleDoubleProperty(billAmountField.text.toDouble()),
                    SimpleIntegerProperty(splitCombo.value),
                    SimpleIntegerProperty(mSlider.value.toInt())
            )
        }
    }
}
