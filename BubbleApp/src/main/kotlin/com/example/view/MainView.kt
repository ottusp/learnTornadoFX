package com.example.view

import com.example.app.Styles
import com.example.controllers.BubbleController
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.MouseDragEvent
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("Bubbles!") {

    private val bubbleController: BubbleController by inject()
    private var myLabel: Label by singleAssign()

    override val root: BorderPane = borderpane {
        setPrefSize(1000.0, 500.0)

        center {
            label {
                myLabel = this
            }
        }

        bottom {
            label ("Click Anywhere") {
                alignment = Pos.BOTTOM_CENTER
                paddingAll = 20.0

                style {
                    opacity = .5
                    fontSize = 25.px
                }
            }
        }
    }.apply {
        style {
            backgroundColor = multi(c("#e0eeee"))
        }


        addEventFilter(MouseDragEvent.MOUSE_CLICKED) {
            bubbleController.addCircle(it, this)
            println("it.x = ${it.x} it.sceneX = ${it.sceneX}")
        }
    }
}
