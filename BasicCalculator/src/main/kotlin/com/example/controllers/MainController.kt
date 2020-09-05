package com.example.controllers

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainController: Controller() {
    val result = SimpleStringProperty("")
    val numbers = ArrayList<Double>()
    val operations = ArrayList<String>()
    var actualDigits = ""

    fun calculate() {
        if(actualDigits.isNotEmpty())
            digitsToNumber()

        if(numbers.size != operations.size + 1){
            println("Size of numbers: ${numbers.size}\n" +
                    "Size of operations: ${operations.size}")
            return
        }
        var doubleResult = numbers[0]
        val times = operations.size

        repeat(times) {
            val nextValue = numbers[it + 1]
            when(operations[it]) {
                "+" -> doubleResult += nextValue
                "-" -> doubleResult -= nextValue
                "*" -> doubleResult *= nextValue
                "/" -> doubleResult /= nextValue
            }

        }

        result.value = doubleResult.toString()
    }

    fun addNumberDigit(number: String) {
        actualDigits += number
        result += number
    }

    fun addOperation(operation: String) {
        digitsToNumber()
        operations.add(operation)
        result += operation
    }

    fun clearNumbers() {
        result.value = ""
        numbers.clear()
        operations.clear()
        actualDigits = ""
    }

    private fun digitsToNumber() {
        if(isDigitsValid()) {
            val number = actualDigits.toDouble()
            numbers.add(number)
            actualDigits = ""
        }
    }

    private fun isDigitsValid(): Boolean {
        return actualDigits.isDouble()
    }

}