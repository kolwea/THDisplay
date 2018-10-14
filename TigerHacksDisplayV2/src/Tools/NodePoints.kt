package Tools

import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Line

class NodePoints(var width : Double, var height :Double) {

    var points: ArrayList<Point> = arrayListOf<Point>()
    var connex : ArrayList<Line> = arrayListOf()

    var radius : Double
    var fill : Color
    var stroke : Color
    var strokeWidth : Double

    var lineWidth : Double
    var lineFill : Color

    init {
        radius = 25.0
        fill = Color.AQUAMARINE
        stroke = Color.BISQUE
        strokeWidth = 5.0

        lineWidth = 5.0
        lineFill = Color.RED

        print("NodePoints created with ")
        print("Points:${points.size} ")
        println("Width:${width} Height:${height}")
    }

    fun createPoints(count:Int){
        for (i in 0 until count) {
            var hold = Point()
            hold.index = i
            hold.radius = radius
            points.add(hold)
        }
    }

    fun setStyle(radius : Double, fill : Color, stroke : Color, strokeWidth : Double){
        this.radius = radius
        this.fill = fill
        this.stroke = stroke
        this.strokeWidth = strokeWidth
        this.updatePointStyles()
    }

    fun updatePointStyles(){
        for(point in points){
            point.radius = radius
            point.fill = fill
            point.stroke = stroke
            point.strokeWidth = strokeWidth
            point.update()
        }
    }
    fun createNewPoint(xPos:Double,yPos:Double){
        val hold = Point()
        hold.setPosition(xPos,yPos)
        hold.radius = radius
        hold.index = points.count()-1
        points.add(hold)
    }

    fun addPointsToPane(rootPane : Pane){
        for(point in points) {
            rootPane.children.add(point.body)
        }
    }

    fun setRandomPositions(width:Double,height:Double) {
        for (point in points) {
            setRandomPosition(point,width, height)
        }
    }

    fun setRandomPositionsNoTouch(width : Double,height: Double){
        for (point in points){
            var touching = false
            do {
                touching = false
                this.setRandomPosition(point,width,height)
                for (pointTouch in points){
                    if (this.pointsIntersect(point,pointTouch))
                        touching = true
                }
            }while (touching)
        }
    }
    fun setRandomPositionsNoTouch(width : Double,height: Double, radius: Double){
        for (point in points){
            var holdRadius = point.radius
            point.radius = radius
            point.update()
            var touching = false
            do {
                touching = false
                this.setRandomPosition(point,width,height)
                for (pointTouch in points){
                    if (this.pointsIntersect(point,pointTouch))
                        touching = true
                }
            }while (touching)
            point.radius = holdRadius
            point.update()
        }
    }

    fun pointsIntersect(pointA : Point, pointB : Point) : Boolean{
        return((pointA != pointB) && pointA.body.intersects(pointB.body.boundsInParent))
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
    
    fun map(runMe:(point : Point) -> Unit){
        for(point in points){
            runMe(point)
        }
    }

    fun connectPoints(){

        for(point in points){
            for(neighbor in point.neighbors){
                var line = Functions.connect(point.body,neighbor.body)
                connex.add(line)
            }
            for (line in point.connex){
                connex.add(line)
            }
        }
    }


    private fun setRandomPosition(point: Point, width: Double, height: Double) {
        val randomX = Math.random() * width
        val randomY = Math.random() * height
        point.setPosition(randomX, randomY)
//        println("Random X:$randomX Y:$randomY")
    }

//    private fun connectPoints(one: Point, two: Point) {
//
//        var bodyA = one.body
//        var bodyB = two.body
//
//        if (one != null && two != null) {
//            var line = Line()
//            line.strokeWidth = lineWidth
//            line.fill = lineFill
//
//            line.startXProperty().bind(bodyA.centerXProperty())
//            line.startYProperty().bind(bodyA.centerYProperty())
//
//            line.endXProperty().bind(bodyB.centerXProperty())
//            line.endYProperty().bind(bodyB.centerYProperty())
//
//            one.connex.add(line)
//        }
//    }


}

