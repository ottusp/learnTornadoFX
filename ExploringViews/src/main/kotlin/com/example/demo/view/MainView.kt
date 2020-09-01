package com.example.demo.view

import com.example.demo.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val topView: TopView by inject()

    val centerView = find(CenterView::class)

    override val root = borderpane {
        top = topView.root

        center = centerView.root

        bottom<BottomView>()

        left<LeftView>()

        right<RightView>()
    }
}