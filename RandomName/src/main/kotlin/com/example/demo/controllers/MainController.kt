package com.example.demo.controllers

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class MainController: Controller() {

    var labelText = SimpleStringProperty()
    val names = listOf("Otto", "Tomé", "你好", "Mirna", "Célio")

    fun changeRandomName() {
        val randomIndex = (names.indices).shuffled().first()

        println("Random number = $randomIndex")
        labelText.value = names[randomIndex]
    }
}