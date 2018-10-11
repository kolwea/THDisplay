package Objects

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class Controller(private var rootPane: Pane){

    var width = 0.0
    var height = 0.0
    private val timekeeper : TimeKeeper
    private val nodePoints : NodePoints

    init{
        width = rootPane.width
        height = rootPane.height
        timekeeper = TimeKeeper()
        nodePoints = NodePoints()
        nodePoints.setPane(rootPane)
        nodePoints.setRandomPositions()
    }

    fun start(){
        timekeeper.start();
    }

    private fun addCircle(){
        val circ = Circle()
        circ.centerX = width/2
        circ.centerY = height/2
        circ.radius = 200.0
        rootPane.children.addAll(circ)
    }
}