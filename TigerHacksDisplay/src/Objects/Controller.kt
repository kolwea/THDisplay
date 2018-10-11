package Objects

import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.shape.Circle
import java.awt.Dimension

class Controller(val rootPane: Pane){

    var dimension = this.getWindowDimension()

    var width: Double = dimension.getWidth()
    var height: Double = dimension.getHeight()


    private val timekeeper: TimeKeeper
    private val nodes: NodePoints
    private val display: Display

    private var circle = Circle()
     var change : Double = 1.0

    init {
        display = Display(this)
        timekeeper = TimeKeeper(this)
        nodes = NodePoints(this)


        addCircle()
    }

    fun start() {
        timekeeper.start()
    }

    fun setupStart(){
        width = rootPane.width
        height = rootPane.height
    }

    fun update() {
        nodes.setRandomPositions()

        var newVal: Double = circle.radius + change

        if(circle.radius == 0.0) {
             change = 1.0
         }
        if(circle.radius == 300.0) {
            change = -1.0
        }
        circle.radius = newVal

    }

    private fun getWindowDimension(): Dimension {
        var windowDimension = java.awt.Toolkit.getDefaultToolkit().screenSize;
        return windowDimension;
    }


    private fun addCircle() {
        if (width != null && height != null) {
            circle.centerX = width /2
            circle.centerY = height / 2
            circle.radius = 300.0
            rootPane.children.add(circle)
        }
    }



}