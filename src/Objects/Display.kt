
class Display(){

    //RootPane for the display
    private var rootPane:Pane;

    //Variables for width and height
    protected val width : double{
        get() = this;
        set(value){
            updateDisplay();
        }
    }
    protected val height : double{
        get() = this;
        set(value){
            updateDisplay();
        }
    }


    init {
        var dimension = getWindowDimension();
        width = dimension.width;
        height = dimension.height;
    }

    fun getWindowDimension(): java.awt.Dimension{
        java.awt.Dimension windowDimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    }

    fun resizeDisplay(int width, int height){
        this.width = width;
        this.height = height;
    }



}