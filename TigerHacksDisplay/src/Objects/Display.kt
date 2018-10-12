package Objects

import Objects.Background.DisplayBackground
import Objects.TigerHead.TigerHead
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane

class Display(var width:Double ,var height:Double) {

    var root: Pane = Pane() //Root Pane for drawing

    var tigerHeadScale = 125.0

    private lateinit var background : DisplayBackground
    private lateinit var backgroundRootPane : Pane

    private lateinit var tigerHead : TigerHead
    private lateinit var tigerHeadPane : StackPane

    init {
        root.setPrefSize(width, height)
        println("Display width:$width height:$height")

        setupBackground()
        setupTigerHead()

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

    private fun setupTigerHead(){
        tigerHead = TigerHead(tigerHeadScale)
        tigerHeadPane = tigerHead.rootPane
        root.children.add(tigerHeadPane)
        tigerHeadPane.translateX = 50.0
    }



}