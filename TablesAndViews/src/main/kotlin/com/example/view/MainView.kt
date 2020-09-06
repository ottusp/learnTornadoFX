package com.example.view

import tornadofx.*

class MainView : View("Hello TornadoFX") {

    private val centerView: CenterView by inject()
    private val leftView: StudentEditorView by inject()

    override val root = borderpane {

//        top = topView.root

        left = leftView.root

        center = centerView.root

//        bottom = bottomView.root
    }
}
