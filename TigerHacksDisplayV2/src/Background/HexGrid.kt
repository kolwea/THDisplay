package Background

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class HexGrid(var width: Double, var height: Double, var size: Double, var flat: Boolean) {

    val extraHex = 3
    val root = Pane()

    val hexWidthFlat = 2 * size
    val hexHeightFlat = size * Math.sqrt(3.0)
    val hexHeightPointy = 2 * size
    val hexWidthPointy = Math.sqrt(3.0) * size

    val horzDistanceFlat = hexWidthFlat * (3 / 4)
    val vertDistanceFlat = hexHeightFlat
    val vertDistancePointy = hexWidthFlat * (3 / 4)
    val horzDistancePointy = hexHeightFlat

    val rows: Array<Double> = Array<Double>(getRowCount()) { 0.0 }
    val cols: Array<Double> = Array<Double>(getColumnCount()) { 0.0 }


    init {
        root.setPrefSize(width, height)
        println("${getColumnCount()} + ${getRowCount()}")
        buildGridFlat()
    }

    fun buildGridFlat() {
        for (r in 0 until rows.size) {
            for (c in 0 until cols.size) {
                if (c % 2 == 0) {
                    cols[c] = (c + 1) * horzDistanceFlat
                    rows[r] = (r + 1) * vertDistanceFlat
                    var testC = (c+1)*horzDistanceFlat
                    var testR = (r+1)*vertDistanceFlat
                    println("$hexHeightFlat + $vertDistanceFlat ")
                } else {
                    cols[c] = (c + 1) * horzDistanceFlat
                    rows[r] = (r + 1) * vertDistanceFlat + (horzDistanceFlat / 2)
                    var testC = (c+1)*horzDistanceFlat
                    var testR = (r+1)*vertDistanceFlat
                    println("$testC + $testR ")
                }
            }
        }
        for (r in 0 until rows.size) {
            for (c in 0 until cols.size) {
                val circ = Circle()
                circ.centerX = cols[c]
                circ.centerY = rows[r]
                circ.radius = 10.0
                root.children.add(circ)
                println("X:${cols[c]} Y:${rows[r]}")
            }

        }
    }


    private fun getRowCount(): Int {
        if (flat) {
            return (height / hexHeightFlat).toInt()
        } else {
            return (height / hexHeightPointy).toInt()
        }
    }

    private fun getColumnCount(): Int {
        if (flat) {
            return (width / hexWidthFlat).toInt()
        } else {
            return (width / hexWidthPointy).toInt()
        }
    }

    fun getHexPointFlat(index: Int, x: Double, y: Double): Pair<Double, Double> {
        var angledegree = 60 * index
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(x + size * Math.cos(angleRadians), y + size * Math.sin(angleRadians))
    }

    fun getHexPointPointy(index: Int, xPos: Double, yPos: Double): Pair<Double, Double> {
        var angledegree = 60 * index - 30.0
        var angleRadians = Math.PI / 180 * angledegree

        return Pair(xPos + size * Math.cos(angleRadians), yPos + size * Math.sin(angleRadians))
    }


}