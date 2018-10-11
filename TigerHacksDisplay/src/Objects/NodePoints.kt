package Objects

import javafx.scene.layout.Pane

class NodePoints(var width : Double, var height :Double) {

    var points: ArrayList<Point> = arrayListOf<Point>()
    var pointRadius = 100.0
        set(value) {
            setAllPointRadius(value)
        }

    init {

        print("NodePoints created with ")
        print("Points:${points.size} ")
        println("Width:${width} Height:${height}")
    }

    fun createPoints(count:Int){
        for (i in 0 until count) {
            var hold = Point()
            hold.index = i
            hold.radius = pointRadius
            points.add(hold)
        }
    }

    fun createNewPoint(xPos:Double,yPos:Double){
        val hold = Point()
        hold.setPosition(xPos,yPos)
        hold.radius = pointRadius
        hold.index = points.count()-1
        points.add(hold)
    }

    fun addPointsToPane(rootPane : Pane){
        for(point in points) {
            rootPane.children.add(point.body)
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
            point.update()
        }
    }

    private fun setRandomPosition(point: Point) {
        val randomX = Math.random() * width
        val randomY = Math.random() * height
        point.setPosition(randomX, randomY)
//        println("Random X:$randomX Y:$randomY")
    }


}