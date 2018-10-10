import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import java.awt.*
import java.awt.event.WindowAdapter
import javax.swing.JFrame
import javax.swing.WindowConstants

class Display() {


    //RootPane for the display
    var frame: JFrame = JFrame() //wrapping frame
    var panel: JFXPanel = JFXPanel() //JavaFX panel w/ Scene
    private var root: Pane = Pane() //Root Pane for drawing

    lateinit var frameWindow: Window // make a window out of frame;

    //Variables for width and height
    var width: Double = 0.0
    var height: Double = 0.0

    //INITIALIZER///////////////////////////////////////////////////////////////////////////////////////////////////////

    init {
//        frame.add(panel)
        panel.scene = Scene(root, 500.0, 500.0)
//        frame.pack()

        addShapeCircle()
    }

    //PUBLIC FUNCTIONS//////////////////////////////////////////////////////////////////////////////////////////////////

    fun resizeDisplay(widthVal: Double, heightVal: Double) {
        this.width = width;
        this.height = height;
        updateDisplay();
    }

    fun addShapeCircle() {
        var circ = Circle()
        circ.radius = 400.0
        circ.centerY = height
        circ.centerX = width
        circ.fill = Paint
                .valueOf("Red")
        root.children.addAll(circ)
    }


    //PRIVATE FUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////


    fun updateDisplay() {
        var windowDimension = getWindowDimension()
        width = windowDimension!!.getWidth()
        height = windowDimension.getHeight()
        println(width.toString() + " " + height)

        initFullscreen()

        frame.minimumSize = Dimension(width.toInt(), height.toInt())
        panel.minimumSize = Dimension(width.toInt(), height.toInt())
        root.setMinSize(width, height)
    }

    private fun getWindowDimension(): Dimension? {
        var windowDimension = java.awt.Toolkit.getDefaultToolkit().screenSize;
        return windowDimension;
    }

    private fun testValues() {
        println("RootPane = " + root);
        println("Window Width: " + width);
        println("Window Height: " + height);
        println();

    }

    //Functions for fullscreen setup

    lateinit var myDevice: GraphicsDevice;
    lateinit var screenDevices: Array<GraphicsDevice>;

    private fun initFullscreen() {
        screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().screenDevices
        chooseScreenDevice()
        if (checkDevice(myDevice)) {
            frame.isUndecorated = true
            frame.ignoreRepaint = true
            myDevice.fullScreenWindow = Window(frame)
        }

        frame.isVisible = false;
        frame.defaultCloseOperation = WindowConstants.HIDE_ON_CLOSE
        frame.add(panel)
        frame.pack()
    }

    private fun chooseScreenDevice() {
        if (screenDevices != null) {
            for (device in screenDevices) {
                println(device.iDstring)
                if (device.iDstring.contains("Display0")) {
                    myDevice = device
                    println()
                    println(myDevice.iDstring)
                }
            }
        } else {
            println("its null")
        }
    }

    private fun checkDevice(device: GraphicsDevice): Boolean {
        return device.isFullScreenSupported
    }

    private fun setupFrame(){
        frame.addWindowListener(})
    }

//    private fun getDisplaySettings(device:GraphicsDevice):DisplayMode{
//        var dispMode = DisplayMode(device.win)
//    }


}