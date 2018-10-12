package Objects.Background

import Objects.NodePoints
import com.sun.org.apache.xpath.internal.operations.Bool
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Polygon
import javafx.scene.shape.Rectangle

class DisplayBackground(var width: Double, var height: Double) {

    var rootPane: Pane = Pane()

    private val size = 25.0
    private val padding = 10.0
    private val extraHex = 3
    private val horzSpacing = size * Math.sqrt(3.0)
    private val vertSpacing = size * 2

    private var hexPane: Pane = Pane()

    private var background: Rectangle = Rectangle()
    private var hexArray: ArrayList<Hexagon> = ArrayList()
    private var nodePoints: NodePoints = NodePoints(width, height)

    init {
        rootPane.setPrefSize(width, height)
        rootPane.children.add(hexPane)
//        setupHexPane()
    }

    private fun setupBottomPane() {

    }

    private fun setupHexPane() {
        var maxWidthCount = Math.round(width / horzSpacing)
        var maxHeightCount = Math.round(height / vertSpacing)

        println("Width/Height count")
        println(maxWidthCount)
        println(maxHeightCount)
        println()
        for (i in 0 - extraHex until maxWidthCount + extraHex) {
            for (j in 0 - extraHex until maxHeightCount + extraHex) {
                var hold: Hexagon
                var xPos: Double = 0.0
                var yPos: Double = 0.0
                if (isEven(i)) {
                    xPos = horzSpacing * i
                    yPos = vertSpacing * j
                } else {
                    xPos = (horzSpacing * i)
                    yPos = (vertSpacing * j) + vertSpacing / 2
                }
                hold = Hexagon(xPos, yPos, size)
                if (isEven(i)) {
                    hold.fill = Color.BLUE

                    hold.updatePoints()
                }

                hexPane.children.add(hold.body)
                println("even")
            }
        }

    }

    private fun isEven(i: Long): Boolean {
        var k = i.toInt()
        return (k % 2 == 0)
    }

}