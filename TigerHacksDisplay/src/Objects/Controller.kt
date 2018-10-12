package Objects

import javafx.scene.layout.Pane
import javafx.scene.shape.Circle
import javafx.stage.Screen
import java.awt.Dimension
import java.awt.Toolkit

class Controller{

    var dimension = getWindowDimension()

    var width: Double = dimension.getWidth()
    var height: Double = dimension.getHeight()

    private val display: Display
    private val timekeeper: TimeKeeper
    private var circle = Circle()

    var rootPane : Pane
    var change : Double = 1.0

    init {

        display = Display(width,height)
        rootPane = display.root

        println("Width: $width Height:$height")
        timekeeper = TimeKeeper(this)
    }

    fun start() {
        timekeeper.start()
    }

    fun update() {
        display.updateDisplay()

    }

    fun addCircle() {
        if (width != null && height != null) {
            circle.centerX = width
            circle.centerY = height
            circle.radius = 300.0
            rootPane.children.add(circle)
        }
    }

    private fun getWindowDimension(): Dimension {
        var windowDimension = Toolkit.getDefaultToolkit().screenSize
        var screen = Screen.getPrimary().bounds
        var dimension = Dimension(Math.ceil(screen.width).toInt(),Math.ceil(screen.height).toInt())
        return dimension;
    }

    private fun setupBackground(){

    }


}