import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle
import java.awt.*
import javax.swing.JFrame

class Display(){


    //RootPane for the display
    var frame : JFrame
    var panel: JFXPanel
    var root : Pane
    var window : Window

    //Variables for width and height
    var width: Double = 0.0

    var height: Double = 0.0

    //INITIALIZER///////////////////////////////////////////////////////////////////////////////////////////////////////

    init{
        var dimension = getWindowDimension();

        frame = JFrame()
        panel = JFXPanel();
        root = Pane();
        window = Window(frame)

        //
        var circ = Circle()
        circ.radius = 400.0
        circ.centerY = height
        circ.centerX = width
        circ.fill = Paint
                .valueOf("Red")

        root.children.addAll(circ)
        //
        width = dimension!!.getWidth();
        height = dimension.getHeight();
        println(width.toString() + " " + height)

        frame.minimumSize = Dimension(Math.round(width).toInt(), Math.round(height).toInt())
        panel.minimumSize = Dimension(Math.round(width).toInt(), Math.round(height).toInt())
        root.setMinSize(width,height)

        frame.add(panel);
        panel.scene = Scene(root,width,height)
        frame.pack()

        initFullscreen();
    }

    //PUBLIC FUNCTIONS//////////////////////////////////////////////////////////////////////////////////////////////////

    fun resizeDisplay(widthVal : Double, heightVal : Double){
        this.width = width;
        this.height = height;
        updateDisplay();
    }


    //PRIVATE FUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////


    fun updateDisplay() {
        var window = getWindowDimension()
        width = window!!.getWidth()
        height = window.getHeight()
        initFullscreen()
    }

    private fun getWindowDimension(): Dimension?{
        var windowDimension = java.awt.Toolkit.getDefaultToolkit().screenSize;
        return windowDimension;
    }

    private fun testValues(){
        println("RootPane = " + root);
        println("Window Width: " + width);
        println("Window Height: " + height);
        println();

    }

    //Functions for fullscreen setup

    lateinit var myDevice : GraphicsDevice;
    lateinit var screenDevices:Array<GraphicsDevice>;

    private fun initFullscreen(){
        screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().screenDevices;
        chooseScreenDevice()
        if(checkDevice(myDevice)){
            frame.isUndecorated = true;
            frame.ignoreRepaint = true;
            myDevice.fullScreenWindow = window;
        }

    }

    private fun chooseScreenDevice(){
        if(screenDevices!=null) {
            for (device in screenDevices) {
                println(device.iDstring)
                if(device.iDstring.contains("Display0")){
                    myDevice = device
                }
            }
        }
    }

    private fun checkDevice(device:GraphicsDevice) : Boolean {
        return device.isFullScreenSupported && device.isDisplayChangeSupported;
    }

//    private fun getDisplaySettings(device:GraphicsDevice):DisplayMode{
//        var dispMode = DisplayMode(device.win)
//    }


}