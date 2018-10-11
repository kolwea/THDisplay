package Objects

import Objects.Background.DisplayBackground
import javafx.scene.layout.Pane

class Display(var width:Double ,var height:Double) {

    var root: Pane = Pane() //Root Pane for drawing
//    var nodes : NodePoints = NodePoints(controller)

    private lateinit var background : DisplayBackground
    private lateinit var backgroundRootPane : Pane

    init {
        root.setPrefSize(width, height)
        println("Display width:$width height:$height")

        setupBackground()
        root.styleClass.add("display")
        println("Display created with Prefsize: (${root.prefWidth}, ${root.prefHeight})")
    }


    fun resizeDisplay(widthVal: Double, heightVal: Double) {
        this.width = width;
        this.height = height;
    }

    //PRIVATE FUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////

    private fun testValues() {
        println("RootPane = " + root);
        println("Window Width: " + width);
        println("Window Height: " + height);
        println();

    }

    private fun setupBackground(){
        background = DisplayBackground(width,height)
        backgroundRootPane = background.rootPane
        root.children.add(backgroundRootPane)
    }



}