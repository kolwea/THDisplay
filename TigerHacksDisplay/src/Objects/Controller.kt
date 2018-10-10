package Objects

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class Controller(private var rootPane: Pane){

    var width = 0.0
    var height = 0.0
    var timekeeper : TimeKeeper

    init{
        width = rootPane.width
        height = rootPane.height
        timekeeper = TimeKeeper()
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