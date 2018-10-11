package Objects

import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import java.awt.*
import javax.swing.JFrame
import javax.swing.WindowConstants

public class Display(var controller:Controller){

//
//    var frame: JFrame = JFrame() //wrapping frame
//    var panel: JFXPanel = JFXPanel() //JavaFX panel w/ Scene
    var root: Pane = controller.rootPane //Root Pane for drawing

    var width: Double = controller.width
    var height: Double = controller.height


    init {
        root.stylesheets.add("Stylesheets/style.css")
        root.styleClass.add("header")
        println(width + height)
    }


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
//        var windowDimension = getWindowDimension()
//        width = windowDimension.getWidth()
//        height = windowDimension.getHeight()

//        initFullscreen()
//        root.setPrefSize(width, height)
    }



    private fun testValues() {
        println("RootPane = " + root);
        println("Window Width: " + width);
        println("Window Height: " + height);
        println();

    }

    //Functions for fullscreen setup

//    lateinit var myDevice: GraphicsDevice;
//    lateinit var screenDevices: Array<GraphicsDevice>;
//
//    private fun initFullscreen() {
//        screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().screenDevices
//        chooseScreenDevice()
//        if (checkDevice(myDevice)) {
//            frame.isUndecorated = true
//            frame.ignoreRepaint = true
//            myDevice.fullScreenWindow = frameWindow
//        }
//        frame.isVisible = false;
//        frame.defaultCloseOperation = WindowConstants.HIDE_ON_CLOSE
//        frame.add(panel)
//        frame.pack()
//    }
//
//    private fun chooseScreenDevice() {
//        if (screenDevices != null) {
//            for (device in screenDevices) {
//                println(device.iDstring)
//                if (device.iDstring.contains("Display0")) {
//                    myDevice = device
//                    println()
//                    println(myDevice.iDstring)
//                }
//            }
//        } else {
//            println("its null")
//        }
//    }

    private fun checkDevice(device: GraphicsDevice): Boolean {
        return device.isFullScreenSupported
    }




}