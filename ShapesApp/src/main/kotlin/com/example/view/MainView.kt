package com.example.view


import javafx.animation.Interpolator
import javafx.scene.paint.Color
import javafx.util.Duration
import tornadofx.*
import kotlin.math.cos
import kotlin.math.sin

class MainView : View("Shapes") {

    private fun f(x: Double): Double {
        return (100 * sin(x) + (37 * cos(x * 3))) * sin(x * 1.7) * 3
    }

    override val root = stackpane {
        group {
//            print("Width = $width")
//            var i = 0.0
//            while (i < 50) {
//                val color = if(i < 5) Color.GREEN else if(i < 10) Color.BLACK else Color.RED
//                add(circle(i*4, f(i * .4), 5){
//                    style {
//                        fill = color
//                    }
//                })
//                i += .1
//            }

            val myCirc = circle {
                radius = 10.0
            }

            timeline {
                keyframe(Duration(500.0)) {
                    keyvalue(myCirc.radiusProperty(), 100, Interpolator.EASE_IN)
                }
                isAutoReverse = true
                cycleCount = 6
            }
        }


    }
}
