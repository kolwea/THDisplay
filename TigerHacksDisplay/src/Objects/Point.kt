package Objects

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

class Point {
    var x = 0.0
        set(value){
            this.body.centerX = value
        }
    var y = 0.0
        set(value){
            this.body.centerY = value
        }
    var radius = 100.0
        set(value){
            body.radius = value
        }
    var body: Circle = Circle()
    var index: Int = 0

    init {
        body.centerX = x;
        body.centerY = y;
        body.radius = radius
        body.fill= Paint.valueOf("Blue")
    }

    fun setPosition(x: Double, y: Double) {
        this.x = x
        this.y = y
//        body.centerX = this.x
//        body.centerY = this.y
        if (index == 0)
            println("X: " + this.x + " Y: " + this.y)
    }

}