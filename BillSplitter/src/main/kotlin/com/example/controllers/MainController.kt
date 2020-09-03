package com.example.controllers

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class MainController: Controller() {

    val totalPerPerson = SimpleDoubleProperty(0.0)
    val tipPercentageAmount = SimpleDoubleProperty(0.0)
    val sliderPercentageAmount = SimpleIntegerProperty(0)

    fun calculate(billAmtValue: SimpleDoubleProperty, splitByValue: SimpleIntegerProperty,
        tipPercVal: SimpleIntegerProperty) {
        tipPercentageAmount.cleanBind(billAmtValue * tipPercVal / 100)
        val totalAmount = tipPercentageAmount.value.toProperty() + billAmtValue
        totalPerPerson.cleanBind(totalAmount / splitByValue)
        sliderPercentageAmount.cleanBind(tipPercVal)
    }
}