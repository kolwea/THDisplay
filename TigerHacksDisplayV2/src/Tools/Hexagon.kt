package Tools

import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.scene.shape.Polygon

class Hexagon(centerX: Double, centerY: Double, initialSize: Double, initialFill: Color, initialStroke: Color, initialStrokeWidth: Double, var flat: Boolean) {

    var body = Polygon()

    var hexPoints = Array(6) { Pair(0.0, 0.0) }

    var x = centerX
        set(value) {
            this.updatePoints()
        }
    var y = centerY
        set(value) {
            updatePoints()
        }
    var size = initialSize
        set(value) {
            updatePoints()
        }
    var fill = initialFill
        set(valeue) {
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
        updateBody()
        updatePoints()
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    fun updatePoints() {
        for (i in 0 until hexPoints.size) {
            val newPoint: Pair<Double, Double>

            if (flat) {
                newPoint = getHexPointFlat(i)
            } else {
                newPoint = getHexPointFlat(i)
            }
            hexPoints[i] = newPoint
        }
        body = Polygon(
                hexPoints[0].first, hexPoints[0].second,
                hexPoints[1].first, hexPoints[1].second,
                hexPoints[2].first, hexPoints[2].second,
                hexPoints[3].first, hexPoints[3].second,
                hexPoints[4].first, hexPoints[4].second,
                hexPoints[5].first, hexPoints[5].second)
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


}