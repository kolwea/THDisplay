package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.*

class HexGlass(var parent: Hexagon, var flowDistance: Double) {

    private val pointRadius = 6.0
    private val pointFill = Color.RED
    private val pointStroke = Color.BLACK
    private val pointStrokeWidth = 1.0

    lateinit var glassPoint: Point
    lateinit var parentPoint: Point
    lateinit var connection: Line


    private val glassFill = Color.valueOf("#F8993A80")

    val centerX = parent.x
    val centerY = parent.y + flowDistance

    lateinit var hexagon : Hexagon
    lateinit var body : Polygon
    var x: Double
    var y: Double

    var connections: ArrayList<Line> = arrayListOf()
    var shapePoints: ArrayList<Pair<Double, Double>> = arrayListOf()
    var changePoints = arrayListOf<Pair<Double, Double>>()

    var anchorPointsHex = arrayListOf<Point>()
    var anchorPointsGlass = arrayListOf<Point>()


    init {
        x = centerX
        y = centerY
        buildHexShape()
        createPoints()

    }

    private fun buildHexShape() {
        hexagon = Hexagon(0.0, 0.0, parent.size, glassFill, Color.ORANGE, 2.0, true)
        body = hexagon.body
        body.translateX = x
        body.translateY = y
    }

    fun setPosition(x:Double,y:Double){
        this.x = x
        this.y = y
        translateBody()
        translatePoint()
    }

    private fun translateBody(){
        body.translateX = x
        body.translateY = y
    }
    private fun translatePoint(){
        glassPoint.body.centerX = x
        glassPoint.body.centerY = y
    }
    private fun createPoints() {
//        for(pos in shapePoints){
            var point = Point(x, y, pointRadius, pointFill, pointStroke, pointStrokeWidth)
            point.body.radius = pointRadius
            point.body.fill = pointFill
            point.body.stroke = pointStroke
            point.body.strokeWidth = pointStrokeWidth
            glassPoint = point

            var pointParent = Point(parent.x, parent.y, pointRadius, pointFill, pointStroke, pointStrokeWidth)
//        point.body.radius = pointRadius
//        point.body.fill = pointFill
//        point.body.stroke = pointStroke
//        point.body.strokeWidth = pointStrokeWidth
            parentPoint = pointParent
            connection = connectPoints(glassPoint.body, parentPoint.body)

//        }
//        for(pos in shapePoints){
//            var point = Point(pos.first,pos.second,pointRadius,Color.BLACK,Color.BLACK,1.0)
//            anchorPointsHex.add(point)
//        }
//        for(i in 0 until shapePoints.size){
//            var hold = connectPoints(anchorPointsHex[i].body,anchorPointsGlass[i].body)
//            connections.add(hold)
//        }
        }

//    fun setPosition(x: Double, y: Double) {
//
//        this.body.y = y
//        this.body.body.toFront()
////        updateBody()
//    }
//
//    fun update() {
////        body.updatePoints()
//        body.update()
//        this.glassPoint.x = body.x
//        this.glassPoint.y = body.y
//        this.glassPoint.body.centerX = body.x
//        this.glassPoint.body.centerY = body.y
//
//
//    }

//        body.points.setAll(
//                changePoints[0].first,changePoints[0].second,
//                changePoints[1].first,changePoints[1].second,
//                changePoints[2].first,changePoints[2].second,
//                changePoints[3].first,changePoints[3].second,
//                changePoints[4].first,changePoints[4].second,
//                changePoints[5].first,changePoints[5].second)
//
//        var i = 0
//        for (point in anchorPointsGlass){
//            point.setPosition(changePoints[i].first,changePoints[i].second)
//            point.update()
//            i++
//        }
//}

        private fun connectPoints(a: Shape, b: Shape): Line {
            val line = Functions.connect(a, b)
            line.fill = Color.GREEN
            line.strokeWidth = 5.0
            line.stroke = Color.GREEN
            return line
        }

    private fun createFlowList(size:Int):Array<Double>{
        val flowScale = 0.0
        val flowChangeValue = 0.0
        val flowMin = 0.0
        val flowMax = 0.0
        val x = centerX
        val y = centerY
        val simplex = OpenSimplexNoise()
        val count = 0.0;
        var list = Array<Double>(size){0.0}
        for(i in 0 until  size){
            val z = count
            val noiseVal = simplex.eval(x  * flowScale , y * flowScale , z )
            list[i] = Functions.map(noiseVal*10, -10.0, 10.0,  flowMin, flowMax)
        }
        return list
    }


    }

