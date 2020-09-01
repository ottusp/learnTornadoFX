package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.*

open class SideView(text: String) : View(text) {
    override val root = vbox {
        alignment = Pos.CENTER

        label("This is a $text view")
        button("Click!")
    }
}

class LeftView : SideView("Left")


class RightView : SideView("Right")