package Objects

import javafx.scene.shape.Circle

class NodePoints(var controller: Controller) {

    var width = 0.0
    var height = 0.0
    var points: ArrayList<Point> = arrayListOf<Point>()
    var count = 100
    var pointRadius = 25.0
        set(value) {
            setAllPointRadius(value)
        }
    init {
        width = controller.width
        height = controller.height
        for (i in 0 until count) {
            var hold = Point()
            hold.index = i
            hold.setPosition(0.0, 0.0)
            hold.radius = pointRadius
            points.add(hold)
            controller.rootPane.children.add(hold.body)
        }
    }


    fun setRandomPositions() {
        for (point in points) {
            setRandomPosition(point)
        }
    }

    fun setAllPositions(x: Double, y: Double) {
        for (point in points) {
            point.setPosition(x, y)
        }
    }

    fun setAllPointRadius(rad : Double){
        for(point in points){
            point.radius = rad
        }
    }

    private fun setRandomPosition(point: Point) {
        val randomX = Math.random() * width
        val randomY = Math.random() * height
        point.setPosition(randomX, randomY)
    }


}