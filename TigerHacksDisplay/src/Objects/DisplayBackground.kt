package Objects

import javafx.scene.layout.Pane

class DisplayBackground(width: Double,height: Double, size : Double){

    private var bottomPane : Pane
    private var topPane : Pane
    var rootPane : Pane



    init {
        bottomPane = Pane()
        topPane = Pane()
        rootPane = Pane()

        rootPane.setPrefSize(width,height)
    }



    private fun drawBackground(width : Double, height: Double){

    }

    private fun getHexCorner(center: Array<Double>, i:Int, scale: Double): Array<Double>{
        var angleDegree = 60 * i - 30
        var angleRadians = Math.PI / 180 * angleDegree

        val x = center[0];
        val y:Double = center[1];

        var valX = x + scale * Math.cos(angleRadians)
        var valY = y + scale * Math.sin(angleRadians)

        return arrayOf(valX, valY)
    }



}