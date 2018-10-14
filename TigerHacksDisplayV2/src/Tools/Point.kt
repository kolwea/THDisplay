package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Line

class Point {
    var body: Circle = Circle()
    var index: Int

    var xPos: Double

    var yPos: Double

    var radius: Double

    var fill : Color

    var stroke: Color

    var strokeWidth: Double

    var neighbors: ArrayList<Point> = ArrayList()

    var connex : ArrayList<Line> = ArrayList()



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

    fun addNeighbor(addMe: Point) {
        if (!neighbors.contains(addMe)) {
            neighbors.add(addMe)
        }
    }

    fun addConnection(addMe:Line){
        if(!connex.contains(addMe))
            connex.add(addMe)
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
    }

}