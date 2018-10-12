package Objects.Base

import Objects.Background.DisplayBackground
import Objects.BackgroundLoading.BackgroundLoad
import Objects.TigerHead.TigerHead
import javafx.scene.layout.Background
import javafx.scene.layout.Pane

class Display(var width:Double ,var height:Double) {

    var root: Pane = Pane() //Root Pane for drawing

    var tigerHeadScale = 125.0

    private lateinit var background : DisplayBackground
    private lateinit var backgroundRootPane : Pane

    private lateinit var tigerHead : TigerHead
    private lateinit var tigerHeadPane : Pane

    private lateinit var loadBackgroud : BackgroundLoad
    private lateinit var loadRoot : Pane

    init {
        root.setPrefSize(width, height)
        println("Display width:$width height:$height")

//        setupBackground()
        setupBackgroundLoad()
        setupTigerHead()

        root.styleClass.add("display")
        println("Display created with Prefsize: (${root.prefWidth}, ${root.prefHeight})")
    }


    fun updateDisplay(){
       tigerHead.updateBounce()
//        tigerHeadPane.translateX = newHeadPos.first
//        tigerHeadPane.translateY = newHeadPos.second
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

    private fun setupBackgroundLoad(){
        loadBackgroud = BackgroundLoad(width,height)
        loadRoot = loadBackgroud.rootPane
        root.children.add(loadRoot)
        loadRoot.toBack()
    }

    private fun setupTigerHead(){
        tigerHead = TigerHead(tigerHeadScale)
        tigerHeadPane = tigerHead.rootPane
        root.children.add(tigerHeadPane)
        tigerHead.setBound(0.0,width-tigerHeadScale,0.0,height-tigerHeadScale)
    }



}