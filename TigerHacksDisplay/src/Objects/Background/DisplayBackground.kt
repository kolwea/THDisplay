package Objects.Background

import Objects.NodePoints
import javafx.scene.layout.Pane
import javafx.scene.shape.Rectangle

class DisplayBackground(var width: Double, var height: Double) {

    var rootPane: Pane = Pane()

    private val size = 55.0
    private val horzSpacing = size * Math.sqrt(3.0)
    private val vertSpacing = size * 2

    private var hexPane: Pane = Pane()

    private var background: Rectangle = Rectangle()
    private var hexArray: ArrayList<Hexagon> = ArrayList()
    private var nodePoints: NodePoints = NodePoints(width, height)

    init {
        rootPane.setPrefSize(width, height)
        rootPane.children.add(hexPane)
        setupHexPane()
    }

    private fun setupBottomPane() {

    }

    private fun setupHexPane() {
//        var hex = Hexagon(500.0,500.0, size)
//        for (coord in hex.hexPoints){
//            nodePoints.createNewPoint(coord.first,coord.second)
//            println("X: ${coord.first} Y: ${coord.second}")
//        }
//        nodePoints.addPointsToPane(hexPane)
        var maxWidthCount = Math.round(width / horzSpacing)
        var maxHeightCount = Math.round(height / vertSpacing)

        println("Width/Height count")
        println(maxWidthCount)
        println(maxHeightCount)
        println()
        for (i in 0 until maxWidthCount) {
            for (j in 0 until maxHeightCount) {
                val hold = Hexagon(i * horzSpacing, j * vertSpacing, size)
                for (coord in hold.hexPoints) {
                    nodePoints.createNewPoint(coord.first, coord.second)
                }
            }
        }
        nodePoints.setAllPointRadius(5.0)
        nodePoints.addPointsToPane(hexPane)
    }

}