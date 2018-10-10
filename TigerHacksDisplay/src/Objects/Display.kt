import javafx.scene.layout.Pane
import java.awt.Dimension

class Display() {

    //RootPane for the display
    var rootPane: Pane

    //Variables for width and height
    var width: Double = 0.0
        set(value) {
            updateDisplay();
        }
    var height: Double = 0.0
        set(value) {
            updateDisplay();
        }

    //INITIALIZER///////////////////////////////////////////////////////////////////////////////////////////////////////

    init{
        var dimension = getWindowDimension();
        rootPane = Pane();
        width = dimension!!.getWidth();
        height = dimension.getHeight();
        updateDisplay();
    }

    //PUBLIC FUNCTIONS//////////////////////////////////////////////////////////////////////////////////////////////////

    fun resizeDisplay(widthVal : Double, heightVal : Double){
        this.width = width;
        this.height = height;
        updateDisplay();
    }


    //PRIVATE FUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////


    private fun updateDisplay() {
        rootPane!!.setMinSize(this!!.width!!, this!!.height!!);
    }

    private fun getWindowDimension(): Dimension?{
        val windowDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        return windowDimension;
    }

    private fun testValues(){
        println("RootPane = " + rootPane);
        println("Window Width: " + width);
        println("Window Height: " + height);
        println();

    }

}