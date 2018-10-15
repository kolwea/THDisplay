package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Line

class Point(centerX:Double,centerY:Double, initialRadius:Double, initialFill : Color, initialStroke : Color, initialStrokeWidth:Double) {



    var body: Circle = Circle()

    var x = centerX

    var y = centerY

    var radius = initialRadius

    var fill = initialFill

    var stroke = initialStroke

    var strokeWidth = initialStrokeWidth


    var neighbors: ArrayList<Point> = ArrayList()

    var connex : ArrayList<Line> = ArrayList()

    init {
        update()
        updateStyle()
        body.radius = 5.0
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

    fun setPosition(x:Double,y:Double){
        body.translateX = x
        body.translateY = y
        update()
//        updateStyle()
    }

    fun update() {
        body.toFront()
    }

    fun updateStyle(){
        body.radius = radius
        body.fill = fill
        body.stroke = stroke
        body.strokeWidth = strokeWidth
    }

}