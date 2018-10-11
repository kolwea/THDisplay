package Objects.Background

import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.Line
import javafx.scene.shape.Polygon
class Hexagon(var centerX: Double,var centerY: Double ,size:Double) {

    var body: Polygon
    var connex : ArrayList<Line> = ArrayList()

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
    var stroke: Paint = Color.BLACK
    var strokeWidth = 1.0


    init {
        body = Polygon()
        updatePoints()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun updatePoints() {
        for (i in 0 until hexPoints.size) {
            val newPoint = getHexPoint(i)
            hexPoints[i] = newPoint
        }
        body = Polygon(
                hexPoints[0].first,hexPoints[0].second,
                hexPoints[1].first,hexPoints[1].second,
                hexPoints[2].first,hexPoints[2].second,
                hexPoints[3].first,hexPoints[3].second,
                hexPoints[4].first,hexPoints[4].second,
                hexPoints[5].first,hexPoints[5].second)

        body.fill = fill
        body.stroke = stroke
        body.strokeWidth = strokeWidth
    }

    fun getHexPoint(i: Int): Pair<Double, Double> {
        var angledegree = 60 * i - 30.0
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(centerX + size * Math.cos(angleRadians), centerY + size * Math.sin(angleRadians))
    }


}