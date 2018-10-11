package Objects

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

class Point{
    var x = 0.0
    var y = 0.0
    var radius = 50.0
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
        val randomX = Math.random() * (width - (-width)) + (-width)/2
        val randomY = Math.random() * (height - (-height)) + (-height)/2
        this.updatePosition(randomX,randomY)
    }

    fun updatePosition(x :Double, y : Double){
        this.x = x
        this.y = y
        body.centerX = x
        body.centerY = y

        println(x + y)
    }

}