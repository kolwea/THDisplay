import Background.FlowField
import Background.HexGrid
import Display.Display
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.layout.StackPane
import javafx.stage.Screen
import javafx.stage.Stage
import java.awt.Dimension
import java.awt.Toolkit

class Controller(private var stage: Stage) {
    private val debug = true


    private val windowWidth: Double
    private val windowHeight: Double

    private val prefWidth = 700.0
    private val prefHeight = 450.0
    private val hexNudgeH = 16.0
    private val hexNudgeV = -10.0
    private val hexSize = 125.0


    lateinit var scene: Scene

    private var rootPane: StackPane

//    private lateinit var background: HexGrid
    private lateinit var background: FlowField
    private lateinit var timekeeper: TimeKeeper
    private lateinit var display: Display

    init {
        val windowDimension = getWindowDimension()
        windowWidth = windowDimension.width.toDouble() + 1
        windowHeight = windowDimension.height.toDouble() + 1

        rootPane = StackPane()
        rootPane.setPrefSize(prefWidth, prefHeight)
        rootPane.styleClass.add("root-view")

        setupView()
        setupControls()
        setupTimekeeper()
        setupPresentation()
        setupKeys()
        timekeeper.start()
    }

    fun update() {
        background.update()
        display.update()
    }

    private fun setupView() {
        if (debug)
            println("Initializing display setup...")

        setupBackground()
        setupDisplay()
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

    private fun setupTimekeeper() {
        timekeeper = TimeKeeper(this)
    }

    private fun setupDisplay(){
        display = Display(windowWidth,windowHeight)
        rootPane.children.add(display.root)
    }

    fun start() {
        stage.scene = scene
        stage.isMaximized = true
        stage.isFullScreen = true
        stage.show()
    }

    private fun setupScene() {
        scene = Scene(rootPane, prefHeight, prefWidth)
        scene.stylesheets.add("/Stylesheets/style.css")
    }

    private fun setupBackground() {
//        background = HexGrid(windowWidth, windowHeight, hexSize, true, hexNudgeH, hexNudgeV)
        background = FlowField(windowWidth,windowHeight)
        rootPane.children.add(background.root)
    }

    private fun getWindowDimension(): Dimension {
        var windowDimension = Toolkit.getDefaultToolkit().screenSize
        var screen = Screen.getPrimary().bounds
        var dimension = Dimension(Math.ceil(screen.width).toInt(), Math.ceil(screen.height).toInt())
        return dimension;
    }

    private fun setupKeys() {
        scene.onKeyPressed = EventHandler { event ->
//            if (event.code == KeyCode.Z) {
//                this.background.flowScale--
//                println(background.flowScale)
//            }
//            if (event.code == KeyCode.X) {
//                this.background.flowScale++
//                println(background.flowScale)
//
//            }
//            if (event.code == KeyCode.K) {
//                this.background.countChangeVal++
//                println(background.countChangeVal)
//            }
//            if (event.code == KeyCode.L) {
//                this.background.countChangeVal--
//                println(background.countChangeVal)
//            }
        }
    }


}