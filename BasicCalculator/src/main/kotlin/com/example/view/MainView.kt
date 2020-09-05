package com.example.view

import com.example.app.Styles
import com.example.controllers.MainController
import javafx.beans.property.SimpleStringProperty
import javafx.scene.input.KeyCode
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode
import tornadofx.*
import java.awt.Label
import java.awt.TextField

class MainView : View("Hello TornadoFX") {

    private val mainController: MainController by inject()
    private val buttonMatrixView: ButtonMatrixView by inject()

    override val root = vbox {
        label(mainController.result) {
            addClass(Styles.heading)
        }

        this.add(buttonMatrixView.root)

        setOnKeyPressed {
            if(it.code == KeyCode.ENTER) {
                mainController.calculate()
            }
        }
    }
}
