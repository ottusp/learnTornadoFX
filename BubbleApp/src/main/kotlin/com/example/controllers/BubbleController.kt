package com.example.controllers

import javafx.animation.Interpolator
import javafx.geometry.Point2D
import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.util.Duration
import tornadofx.*
import kotlin.random.Random

class BubbleController: Controller() {

    fun addCircle(mouseEvent: MouseEvent, root: Node) {
        val mousePoint: Point2D = root.sceneToLocal(mouseEvent.sceneX, mouseEvent.sceneY)
        val color = randomColor()
        val circle = Circle(mousePoint.x, mousePoint.y, 20.0, color)
        circle.apply {
            animateFill(Duration.seconds(1.5), color, Color.TRANSPARENT)
        }
        timeline {
            keyframe(Duration.seconds(2.4)) {
                keyvalue(circle.radiusProperty(), 200, Interpolator.EASE_BOTH)
            }
        }

        root.getChildList()!!.add(circle)
    }

    private fun randomColor(): Color {
        val random = Random.nextInt()
        val colorCode = Integer.toHexString(random.shr(8))

        return c("#$colorCode")
    }
}