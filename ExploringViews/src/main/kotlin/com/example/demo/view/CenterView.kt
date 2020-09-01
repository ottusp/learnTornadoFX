package com.example.demo.view

import tornadofx.*

class CenterView : View("Center View") {
    override val root = borderpane {
        center {
            label("This is the center!")
            button("Click!")
        }
    }
}
