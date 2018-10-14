package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.scene.shape.Polygon
import javafx.scene.shape.Shape

class HexGlass(parent:Hexagon){

    private val pointRadius = 6.0
    private val pointFill = Color.RED
    private val pointStroke = Color.BLACK
    private val pointStrokeWidth = 1.0

     val centerX = parent.x
     val centerY = parent.y

    private val glassFill = Color.valueOf("#F8993A80")
    private val flowDistance = 10.0

    var body = Polygon()

    var connections : ArrayList<Line> = arrayListOf()
    var shapePoints:ArrayList<Pair<Double,Double>> = arrayListOf()
    var changePoints = arrayListOf<Pair<Double,Double>>()

    var anchorPointsHex = arrayListOf<Point>()
    var anchorPointsGlass = arrayListOf<Point>()


    init{
        for(point in parent.hexPoints){
            shapePoints.add(point)
        }
        changePoints = shapePoints
        buildHexShape()
        createPoints()
//        connectHex()
    }

    private fun buildHexShape(){
        body = Polygon(
                shapePoints[0].first,shapePoints[0].second - flowDistance,
                shapePoints[1].first,shapePoints[1].second - flowDistance,
                shapePoints[2].first,shapePoints[2].second - flowDistance,
                shapePoints[3].first,shapePoints[3].second - flowDistance,
                shapePoints[4].first,shapePoints[4].second - flowDistance,
                shapePoints[5].first,shapePoints[5].second - flowDistance)
        body.fill = glassFill
    }

    private fun createPoints(){
        for(pos in shapePoints){
            var point = Point(pos.first,pos.second,pointRadius,pointFill,pointStroke,pointStrokeWidth)
            point.body.radius = pointRadius
            point.body.fill = pointFill
            point.body.stroke = pointStroke
            point.body.strokeWidth = pointStrokeWidth
            anchorPointsGlass.add(point)
        }
        for(pos in shapePoints){
            var point = Point(pos.first,pos.second,pointRadius,Color.BLACK,Color.BLACK,1.0)
            anchorPointsHex.add(point)
        }
        for(i in 0 until shapePoints.size){
            var hold = connectPoints(anchorPointsHex[i].body,anchorPointsGlass[i].body)
            connections.add(hold)
        }
    }

    fun updateBody(){
        body.points.setAll(
                changePoints[0].first,changePoints[0].second,
                changePoints[1].first,changePoints[1].second,
                changePoints[2].first,changePoints[2].second,
                changePoints[3].first,changePoints[3].second,
                changePoints[4].first,changePoints[4].second,
                changePoints[5].first,changePoints[5].second)

        var i = 0
        for (point in anchorPointsGlass){
            point.setPosition(changePoints[i].first,changePoints[i].second)
            point.update()
            i++
        }
    }

    private fun connectPoints(a:Shape,b:Shape):Line{
        val line = Functions.connect(a,b)
        line.fill = Color.GREEN
        line.strokeWidth = 5.0
        line.stroke = Color.GREEN
        return line
    }


}