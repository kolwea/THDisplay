package Objects

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class NodePoints(var controller : Controller) {

    var width = 0.0
    var height = 0.0
    var points: ArrayList<Point> = arrayListOf<Point>()
    val size = 100

    init {
        width = controller.width
        height = controller.height
        for (i in 0..size-1){
            var hold = Point()
            hold.body = Circle()
            hold.index = i
            points.add(hold)
            controller.rootPane.children.add(hold.body)
        }
    }


    fun setRandomPositions() {
        for (point in points) {
            point.setRandomPosition(width, height)
        }
    }

    fun setNodePositions(x:Double,y:Double){
        for (point in points){
            point?.updatePosition(x,y)
        }
    }


}