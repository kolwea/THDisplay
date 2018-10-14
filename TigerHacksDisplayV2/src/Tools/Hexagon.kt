package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.*

class Hexagon(centerX: Double, centerY: Double, initialSize: Double, initialFill: Color, initialStroke: Color, initialStrokeWidth: Double, var flat: Boolean) {

    var body:Polygon = Polygon()

    var hexPoints : Array<Pair<Double,Double>>

    var x : Double

    var y :Double

    var size = initialSize
        set(value) {
            updatePoints()
        }
    var fill = initialFill
        set(value) {
            this.updateBody()
        }
    var stroke = initialStroke
        set(value) {
            this.updateBody()
        }
    var strokeWidth = initialStrokeWidth
        set(value) {
            this.updateBody()
        }

    //Extra
    var connex: ArrayList<Line> = ArrayList()

    init {
        x = centerX
        y = centerY
        hexPoints = Array(6){ Pair(0.0,0.0) }
        updateBody()
        updatePoints()
        createShape()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private fun updatePoints() {
        for (i in 0 until hexPoints.size) {
            val newPoint: Pair<Double, Double>

            if (flat) {
                newPoint = getHexPointFlat(i)
            } else {
                newPoint = getHexPointPointy(i)
            }
            hexPoints[i] = newPoint
        }
        var hold :Polygon = body as Polygon
        hold.points.setAll(
                hexPoints[0].first, hexPoints[0].second,
                hexPoints[1].first, hexPoints[1].second,
                hexPoints[2].first, hexPoints[2].second,
                hexPoints[3].first, hexPoints[3].second,
                hexPoints[4].first, hexPoints[4].second,
                hexPoints[5].first, hexPoints[5].second)
    }

    fun update(){
        body.translateX = x
        body.translateY = y
    }

    private fun updateBody() {
        body.fill = fill
        body.strokeWidth = strokeWidth
        body.stroke = stroke
    }

    private fun getHexPointFlat(index: Int): Pair<Double, Double> {
        var angledegree = 60 * index
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(x + size * Math.cos(angleRadians), y + size * Math.sin(angleRadians))
    }

    private fun getHexPointPointy(index: Int): Pair<Double, Double> {
        var angledegree = 60 * index - 30.0
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(x + size * Math.cos(angleRadians), y + size * Math.sin(angleRadians))
    }

    fun createShape():Shape{
        var square = Rectangle()
        square.width = 2 * size
        square.height = size * Math.sqrt(3.0)
        var hold = Path.subtract(square,body)
        var done = Path.subtract(hold,square)
        return done
    }



}