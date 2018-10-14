import Background.HexGrid
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.stage.Stage
import java.awt.Dimension
import java.awt.Toolkit

class Controller(private var stage:Stage) {
    private val debug = true


    private val windowWidth: Double
    private val windowHeight: Double

    private val prefWidth = 700.0
    private val prefHeight = 450.0

    lateinit var scene: Scene

    private var rootPane: StackPane

    private lateinit var background: HexGrid
    private val hexSize = 40.0

    init {
        val windowDimension = getWindowDimension()
        windowWidth = windowDimension.width.toDouble() + 1
        windowHeight = windowDimension.height.toDouble() + 1

        rootPane = StackPane()

        setupDisplay()
        setupControls()
        setupPresentation()
    }

    private fun setupDisplay() {
        if (debug)
            println("Initializing display setup...")

        setupBackground()
        setupScene()

        if (debug)
            println("Display setup complete.")
    }

    private fun setupControls() {
        if (debug)
            println("Initializing display setup...")

        if (debug)
            println("Display setup complete.")
    }

    private fun setupPresentation() {

    }

     fun start(){
         stage.scene = scene
         stage.isMaximized = true
         stage.isFullScreen = true
         stage.show()
    }

    private fun setupScene(){
        scene = Scene(rootPane,prefHeight,prefWidth)
        scene.stylesheets.add("/Stylesheets/style.css")
    }

    private fun setupBackground(){
        background = HexGrid(windowWidth,windowHeight,hexSize,true)
        rootPane.children.add(background.root)
    }

    private fun getWindowDimension(): Dimension {
        var windowDimension = Toolkit.getDefaultToolkit().screenSize
        var screen = Screen.getPrimary().bounds
        var dimension = Dimension(Math.ceil(screen.width).toInt(), Math.ceil(screen.height).toInt())
        return dimension;
    }


}