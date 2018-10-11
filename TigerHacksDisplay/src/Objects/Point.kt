package Objects

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

class Point{
    var x = 0.0
    var y = 0.0
    var radius = 10.0
    var body : Circle
    var index : Int = 0

    init{
        body = Circle()
        body.centerX = x;
        body.centerY = y;
        body.radius = radius
        body.fill = Paint.valueOf("Blue")
    }

    fun setRandomPosition(width : Double, height : Double){
        val randomX = Math.random() * height
        val randomY = Math.random() * width
    }

    fun updatePosition(x :Double, y : Double){
        this.x = x
        this.y = y
        body.centerX = x
        body.centerY = y
    }

}