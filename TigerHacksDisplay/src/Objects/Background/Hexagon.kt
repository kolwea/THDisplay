package Objects.Background

import java.awt.Color
import java.awt.Paint
import java.awt.Polygon

class Hexagon(var centerX: Double,var centerY: Double ,size:Double) {

    var hex: Polygon = Polygon()

    var hexPoints: Array<Pair<Double, Double>> = arrayOf(
            Pair(0.0, 0.0),
            Pair(0.0, 0.0),
            Pair(0.0, 0.0),
            Pair(0.0, 0.0),
            Pair(0.0, 0.0),
            Pair(0.0, 0.0)
    )

    var size = size
        set(value) {
            updatePoints()
        }

    var fill: Paint = Color.GREEN

    init {
        updatePoints()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun updatePoints() {
        for (i in 0 until hexPoints.size) {
            val newPoint = getHexPoint(i)
            hexPoints[i] = newPoint
//            println(newPoint.toString())
        }
    }

    fun getHexPoint(i: Int): Pair<Double, Double> {
        var angledegree = 60 * i - 30.0
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(centerX + size * Math.cos(angleRadians), centerY + size * Math.sin(angleRadians))
    }

}