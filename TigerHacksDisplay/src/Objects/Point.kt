package Objects

import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

class Point {
    var body: Circle = Circle()
    var index: Int
    var xPos : Double
    var yPos : Double
    var radius : Double
    var fill: Paint
    var stroke: Paint
    var strokeWidth: Double


    init {
        xPos = 0.0
        yPos = 0.0
        index = -1
        radius = 10.0
        fill = Color.RED
        stroke = Color.BLACK
        strokeWidth = 5.0
        update()
    }

    fun setPosition(x: Double, y: Double) {
        xPos = x
        yPos = y
        update()
    }

     fun update() {
        body.radius = radius
        body.centerX = xPos
        body.centerY = yPos
        body.fill = fill
        body.stroke = stroke
        body.strokeWidth = strokeWidth
        body.toFront()
//        println("Point-$index updated.")
    }

}