package Objects

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class NodePoints() {

    var width = 0.0
    var height = 0.0
    var points: Array<Point?> = arrayOf<Point?>()
    val size = 100;

    init {
        points = arrayOfNulls<Point>(size)
        for (i in 0..size-1){
            val hold = Point()
            hold.body = Circle()
            hold.index = i
            points[i] = hold
            println("Point - " + hold.index)
        }
    }

    fun setPane(rootPane: Pane) {
            for (point in points) {
                rootPane.children.remove(point?.body)
                rootPane.children.add(point?.body)
            width = rootPane.width
            height = rootPane.height
            println("Pane set for points.")
        }
    }

    fun setRandomPositions() {
        for (point in points) {
            point?.setRandomPosition(width, height)
        }
    }

    fun setNodePositions(x:Double,y:Double){
        for (point in points){
            point?.updatePosition(x,y)
        }
    }


}