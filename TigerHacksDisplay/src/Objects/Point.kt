package Objects

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

class Point {
    var x = 200.0
    var y = 100.0
    var radius = 100.0
    var body: Circle = Circle()
    var index: Int = 0

    init {
        body.centerX = x;
        body.centerY = y;
        body.radius = radius
        body.fill= Paint.valueOf("Blue")
    }

    fun setRandomPosition(width: Double, height: Double) {
        val randomX = Math.random() * (width - (-width)) + (-width)
        val randomY = Math.random() * (height - (-height)) + (-height)
        this.updatePosition(randomX, randomY)
    }

    fun updatePosition(x: Double, y: Double) {
        this.x = x
        this.y = y
        body.centerX = this.x
        body.centerY = this.y

        if (index == 0)
            println("X: " + this.x + " Y: " + this.y)
    }

}