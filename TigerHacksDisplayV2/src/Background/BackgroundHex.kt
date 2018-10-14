package Background

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle
import javafx.scene.shape.Polygon

class BackgroundHex(var width: Double, var height: Double) {
    val debug = false

    private val pointRadius = 10.0
    private val hexSize = 20.0
    private val hexExtra = 2
    private val hexPadding = 5.0
    private val startHex = 0.0
    private val hexHorizontalSpacing = hexSize * Math.sqrt(3.0)
    private val hexVerticalSpacing = hexSize * 2

    var rootPane: Pane = Pane()
    var hexPoints: ArrayList<Point>
    var hexagons: ArrayList<Hexagon>
    var hexHold: ArrayList<Hexagon> = ArrayList()

    init {
        rootPane.setPrefSize(width, height)
        hexPoints = arrayListOf()
        hexagons = arrayListOf()
        setupHexField()
    }

    private fun setupHexField() {
        setupHexPoints()
        addHexsToPane()
        if (debug) {
            println("Hex field setup complete.")
        }
    }

    private fun setupHexPoints() {
        var head = createHexagon(startHex,startHex)
        hexagons.add(head)
        var adj = head.getCenterAdjacentBelow(0)

        var hexLeft = arrayListOf<Hexagon>()
        var curr = head
        var count = 0
        while(curr.y < height){
            val pos = curr.getCenterAdjacentBelow(count)
            val hold = createHexagon(pos.first+hexPadding,pos.second+hexPadding)
            hexLeft.add(hold)
            curr = hold
            count++
        }

        hexagons.addAll(hexLeft)
    }

    private fun findHexTotalRowCount(): Int {
        val count = width / hexHorizontalSpacing
        if (debug) {
            println("Hex total row count: $count")
        }
        return count.toInt() + hexExtra
    }

    private fun findHexTotalColumnCount(): Int {
        val count = height / hexVerticalSpacing
        if (debug) {
            println("Hex total row count: $count")
        }
        return count.toInt() + hexExtra
    }

    private fun createBaseRow(): ArrayList<Pair<Double, Double>> {
        val row: ArrayList<Pair<Double, Double>> = arrayListOf()
        for (i in 0 until findHexTotalColumnCount() + hexExtra) {
            var pos = Pair(i * hexHorizontalSpacing, 0.0)
            row.add(pos)
        }
        return row
    }

    private fun initNeighbors(hex: Hexagon): ArrayList<Hexagon> {
        val list = arrayListOf<Hexagon>()
        for (i in hex.findNeighborPositionPointy()) {
            if (checkInBoundsHeight(i.second) && checkInBoundsWidth(i.first)) {
                list.add(createHexagon(i.first, i.second))
            }
        }
        return list
    }

    private fun checkInBoundsWidth(x: Double): Boolean {
        if (x > width)
            return false
        if (x < 0)
            return false
        return true
    }

    private fun checkInBoundsHeight(y: Double): Boolean {
        if (y > height)
            return false
        if (y < 0)
            return false
        return true
    }

    private fun createPoint(index: Int, x: Double, y: Double): Point {
        return Point(index, x, y, pointRadius)
    }

    private fun setupHexShapes() {
        for (i in 0 until hexPoints.size) {
            val point = hexPoints[i]
            val hex = createHexagon(point.posX, point.posY)
            hexagons.add(hex)
            if (debug) {
                println("New hexagon created with properties: Position-(${point.posX},${point.posY})")
            }
        }
    }

    private fun createHexagon(x: Double, y: Double): Hexagon {
        return Hexagon(x, y, hexSize)
    }

    private fun addPointsToPane() {
        for (point in hexPoints) {
            rootPane.children.add(point.body)
        }
    }

    private fun addHexsToPane() {
        for (hex in hexagons) {
            rootPane.children.add(hex.body)
        }
    }

//Classes

    class Point(i: Int, var posX: Double, var posY: Double, radius: Double) {
        val body = Circle()
        val index = i

        init {
            body.styleClass.add("background-point")
            body.radius = radius
        }
    }

    class Hexagon(val x: Double, val y: Double, val size: Double) {
        var index: Int = 0
        var marked:Boolean = false
        val points = getAllHexPointsPointy()
        val body = buildPolygon(points)
        val neighbors = ArrayList<Hexagon>()

        init {
            body.styleClass.add("background-hexagon")

        }

        fun buildPolygon(points: Array<Pair<Double, Double>>): Polygon {
            return Polygon(
                    points[0].first, points[0].second,
                    points[1].first, points[1].second,
                    points[2].first, points[2].second,
                    points[3].first, points[3].second,
                    points[4].first, points[4].second,
                    points[5].first, points[5].second
            )
        }

        fun getAllHexPointsPointy(): Array<Pair<Double, Double>> {
            val points = arrayOf(
                    getHexPointP(0, x, y, size), getHexPointP(1, x, y, size),
                    getHexPointP(2, x, y, size), getHexPointP(3, x, y, size),
                    getHexPointP(4, x, y, size), getHexPointP(5, x, y, size))
            return points
        }

        fun buildNeighbors(){
            val list = this.findNeighborPositionPointy()
            for(point in list){
                neighbors.add(Hexagon(point.first,point.second,size))
            }
        }

        fun getAllHexPointsFlat(): Array<Pair<Double, Double>> {
            val points = arrayOf(
                    getHexPointF(0, x, y, size), getHexPointF(1, x, y, size),
                    getHexPointF(2, x, y, size), getHexPointF(3, x, y, size),
                    getHexPointF(4, x, y, size), getHexPointF(5, x, y, size))
            return points
        }

        fun getHexPointP(i: Int, x: Double, y: Double, size: Double): Pair<Double, Double> {
            var angledegree = 60 * i - 30.0
            var angleRadians = Math.PI / 180 * angledegree

            return Pair(x + size * Math.cos(angleRadians), y + size * Math.sin(angleRadians))
        }

        fun getHexPointF(i: Int, x: Double, y: Double, size: Double): Pair<Double, Double> {
            var angledegree = 60 * i
            var angleRadians = Math.PI / 180 * angledegree

            return Pair(x + size * Math.cos(angleRadians), y + size * Math.sin(angleRadians))
        }

        fun findNeighborPositionPointy(): Array<Pair<Double, Double>> {
            return arrayOf(
                    getHexPointF(0, x, y, 2 * size), getHexPointF(1, x, y, 2 * size),
                    getHexPointF(2, x, y, 2 * size), getHexPointF(3, x, y, 2 * size),
                    getHexPointF(4, x, y, 2 * size), getHexPointF(5, x, y, 2 * size))
        }

        fun findNeighborPositionFlat(): Array<Pair<Double, Double>> {
            return arrayOf(
                    getHexPointP(0, x, y, 2 * size), getHexPointP(1, x, y, 2 * size),
                    getHexPointP(2, x, y, 2 * size), getHexPointP(3, x, y, 2 * size),
                    getHexPointP(4, x, y, 2 * size), getHexPointP(5, x, y, 2 * size))

        }

        fun getCenterAdjacentBelow(index:Int):Pair<Double,Double>{
            var neighbors = getAllHexPointsPointy()
            for(point in neighbors)
                println("X:${point.first} Y:${point.second}")
            if(index%2==0)
                return neighbors[1]
            return neighbors[3]
        }
    }
}