package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controllers.MainController
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*
import java.util.*
import kotlin.math.abs

class MainView : View("Random Name") {

    val mainController: MainController by inject()

    override val root = vbox {

        alignment = Pos.CENTER

        label {
            bind(mainController.labelText)
            addClass(Styles.heading)
        }

        button {
            text = "Click me!"
            action {
                mainController.changeRandomName()
            }
        }
    }
}