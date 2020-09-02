package com.example.view

import com.example.app.Styles
import com.example.controllers.MainController
import javafx.collections.FXCollections
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    private val topView: TopView by inject()
    private val bottomView: BottomView by inject()
    private val centerView: CenterView by inject()
    private val leftView: StudentEditor by inject()

    override val root = borderpane {

        top = topView.root

        left = leftView.root

        center = centerView.root

        bottom = bottomView.root
    }
}
