package Background

import Tools.Functions
import Tools.HexGlass
import Tools.Hexagon
import Tools.OpenSimplexNoise
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javax.xml.crypto.dom.DOMCryptoContext

class HexGrid(var width: Double, var height: Double, private var size: Double, private var flat: Boolean, var nudgeH: Double, var nudgeV: Double) {

    private val extraHexWidth = 9
    private val extraHexHeight = 3
    private val addCircles = false
    val flowMax = 1.0
    val flowMin = -1.0
    var flowScale = .0019
    val root = Pane()
    var count = 0.0
    var countChangeVal = 100


    private val paddingRatio = 0.06
    private val hexPadding = paddingRatio * size
    private val fill = Color.RED
    private val stroke = Color.BLACK
    private val strokeWidth = 2.0

    private val hexWidthFlat = 2 * size
    private val hexHeightFlat = size * Math.sqrt(3.0)
    private val hexHeightPointy = 2 * size
    private val hexWidthPointy = Math.sqrt(3.0) * size

    private val horzDistanceFlat = hexWidthFlat * 3 / 4
    private val vertDistanceFlat = hexHeightFlat
    private val vertDistancePointy = hexWidthFlat * (3 / 4)
    private val horzDistancePointy = hexHeightFlat

    private val rows = Array<Double>(getRowCount()) { 0.0 }
    private val cols = Array<Double>(getColumnCount()) { 0.0 }
    private val hexagons: ArrayList<Hexagon>
    private val hexGlass: ArrayList<HexGlass>

    private val hexCenterPositions: ArrayList<Pair<Double, Double>>


    init {

        root.setPrefSize(width, height)
        hexCenterPositions = getHexCenters()
        hexagons = getHexagonShapes(hexCenterPositions)
        hexGlass = arrayListOf()
        addHexagonsToPane()
        setupGlass()
        addGlass()
    }

    fun getHexCenters(): ArrayList<Pair<Double, Double>> {
        for (r in 0 until rows.size) {
            for (c in 0 until cols.size) {
                cols[c] = (c * horzDistanceFlat) + nudgeH
                rows[r] = (r * vertDistanceFlat) + nudgeV
            }
        }

        val points = ArrayList<Pair<Double, Double>>()

        for (r in 0 until rows.size) {
            for (c in 0 until cols.size) {
                if (c % 2 == 0) {
                    points.add(Pair(cols[c], rows[r]))
                } else {
                    points.add(Pair(cols[c], rows[r] + vertDistanceFlat / 2))
                }
            }
        }
        if (addCircles)
            for (position in points) {
                val circle = Circle()
                circle.radius = 5.0
                circle.fill = Color.RED
            }
        return points
    }

    fun map(runMe: (hex: Hexagon) -> Unit) {
        for (hex in hexagons) {
            runMe(hex)
        }
    }

    private fun getHexagonShapes(positions: ArrayList<Pair<Double, Double>>): ArrayList<Hexagon> {
        val list = arrayListOf<Hexagon>()
        for (center in positions) {
            var hex = createHexagon(center.first, center.second, size - hexPadding)
            list.add(hex)
        }
        return list
    }

    private fun addHexagonsToPane() {
        for (hex in hexagons) {
            root.children.add(hex.body)
        }
    }

    private fun createHexagon(centerX: Double, centerY: Double, size: Double): Hexagon {
        return Hexagon(centerX, centerY, size, fill, stroke, strokeWidth, flat)
    }

    private fun getRowCount(): Int {
        if (flat) {
            return (height / hexHeightFlat).toInt() + extraHexHeight
        } else {
            return (height / hexHeightPointy).toInt() + extraHexHeight
        }
    }

    private fun getColumnCount(): Int {
        if (flat) {
            return (width / hexWidthFlat).toInt() + extraHexWidth
        } else {
            return (width / hexWidthPointy).toInt() + extraHexWidth
        }
    }

    private fun setupGlass() {
        for (hex in hexagons) {
            var hold = HexGlass(hex)
            hexGlass.add(hold)
        }
    }

    private fun addGlass() {
        for (hex in hexGlass) {
            root.children.add(hex.body)
            root.children.addAll(hex.connections)
            for(point in hex.anchorPointsHex){
                root.children.addAll(point.body)
                point.body.toBack()
            }
            for(point in hex.anchorPointsGlass){
                root.children.addAll(point.body)
                point.body.toFront()
            }
            for (line in hex.connections) {
//                root.children.addAll(line)
                line.toFront()
            }
            hex.body.toFront()
        }
    }

    fun update() {
//        var shapeList = arrayListOf<ArrayList<Pair<Double,Double>>>()
        for (glass in hexGlass) {
            updateNoiseField(glass)
        }
        for (glass in hexGlass) {
            glass.updateBody()
            glass.body.toFront()
        }
        count += countChangeVal
    }

    fun updateNoiseField(glass: HexGlass) {
        val points = glass.shapePoints
        val list = glass.changePoints
        for (i in 0 until points.size) {
            val pos = points[i]
            val x = pos.first
            val y = pos.second
            val z = count

            val simplex = OpenSimplexNoise()
            val noiseVal = simplex.eval(x * flowScale, y * flowScale, z)
            val newY = Functions.map(noiseVal, -1.0, 1.0, flowMin, flowMax)
            list[i] = Pair(glass.shapePoints[i].first, glass.shapePoints[i].second + newY)
        }
        glass.changePoints = list
    }


}