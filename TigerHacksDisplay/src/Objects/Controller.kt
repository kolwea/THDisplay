package Objects

import Objects.Presentation.Presentation
import javafx.scene.layout.Pane
import javafx.scene.shape.Circle
import javafx.stage.Screen
import java.awt.Dimension
import java.awt.Toolkit
import java.io.File

class Controller{

    var dimension = getWindowDimension()

    var width: Double = dimension.getWidth()
    var height: Double = dimension.getHeight()

    lateinit var folder : File

    private val display: Display
    private val timekeeper: TimeKeeper
    private lateinit var presentation : Presentation
    private var circle = Circle()

    var rootPane : Pane

    init {
        display = Display(width, height)
        rootPane = display.root
        timekeeper = TimeKeeper(this)
    }

    fun setup(){
        setupBackground()
//        setupPresentation()
//        println()

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

    fun setFile(file : File){
        folder = file
        setupPresentation()
    }

    fun nextSlide(){
        if (display.presentation!=null){
            display.nextSlide()
        }
    }

    fun prevSlide(){
        if (display.presentation!=null){
            display.prevSlide()
        }
    }

    fun stopHead(){
        display.tigerHead.goto(500.0,500.0)
    }

    fun addContent(){
        display.addContentPane()
    }




    private fun setupBackground(){
        display.setupBackgroundLoad()
    }

    private fun setupPresentation(){
        presentation = display.setupPresentation(folder)
    }

    private fun getWindowDimension(): Dimension {
        var windowDimension = Toolkit.getDefaultToolkit().screenSize
        var screen = Screen.getPrimary().bounds
        var dimension = Dimension(Math.ceil(screen.width).toInt(),Math.ceil(screen.height).toInt())
        return dimension;
    }




}