package Objects

import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.shape.Circle

class Controller() {

    private var width: Double
    private var height: Double

    private val rootPane: Pane;
    private val timekeeper: TimeKeeper
    private var nodes: NodePoints
    private val display: Display = Display()

    private var circle = Circle()

    init {
        rootPane = display.root
        width = rootPane.width
        height = rootPane.height
        timekeeper = TimeKeeper(this)
        nodes = NodePoints()
        nodes.setPane(rootPane)
        addCircle()
    }

    fun start() {
        timekeeper.start();
    }

    fun update() {
        nodes.setRandomPositions()
        var newVal = 0.0
        if (circle?.radius!! >= 0)
            newVal = circle?.radius!!.toDouble() - 25.0
        else
            newVal = circle?.radius!!.toDouble() + 25.0
    }

    fun getScene():Scene{
        return display.panel.scene
    }


    private fun addCircle() {
        if (width != null && height != null) {
            circle.centerX = width / 2
            circle.centerY = height / 2
            circle.radius = 200.0
            rootPane.children.addAll(circle)
        }
    }

}