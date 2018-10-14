package Objects

import Objects.Background.DisplayBackground
import Objects.BackgroundLoading.BackgroundLoad
import Objects.Presentation.Presentation
import Objects.TigerHead.TigerHead
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import java.io.File

class Display(var width:Double ,var height:Double) {

    val contentPadding = 10.0
    val contentScale = 0.4

    var root: Pane = Pane() //Root Pane for drawing
    var contentPane = StackPane()

    var tigerHeadScale = 125.0

     lateinit var background : DisplayBackground
    private lateinit var backgroundRootPane : Pane

     lateinit var tigerHead : TigerHead
    private lateinit var tigerHeadPane : Pane

    lateinit var loadBackgroud : BackgroundLoad
    private lateinit var loadRoot : Pane

     lateinit var presentation : Presentation
    private lateinit var presentationRoot : Pane

    init {
        root.setPrefSize(width, height)
        contentPane.setPrefSize(width,height)
        contentPane.styleClass.add("content-pane")

        setupBackgroundLoad()
        setupTigerHead()

        root.styleClass.add("display")
        println("Display created with Prefsize: (${root.prefWidth}, ${root.prefHeight})")
    }


    fun addContentPane(){
        root.children.addAll(contentPane)
        tigerHeadPane.toFront()

    }
    fun updateDisplay(){
       tigerHead.updateBounce()
        loadBackgroud.update()

    }
    fun resizeDisplay(widthVal: Double, heightVal: Double) {
        this.width = width;
        this.height = height;
    }

    //PRIVATE FUNCTIONS/////////////////////////////////////////////////////////////////////////////////////////////////

    private fun setupBackground(){
        background = DisplayBackground(width,height)
        backgroundRootPane = background.rootPane
        root.children.add(backgroundRootPane)
    }

    fun setupBackgroundLoad(){
        loadBackgroud = BackgroundLoad(width,height)
        loadRoot = loadBackgroud.rootPane
        root.children.add(loadRoot)
        loadRoot.toBack()
    }

    fun setupTigerHead(){
        tigerHead = TigerHead(tigerHeadScale)
        tigerHeadPane = tigerHead.rootPane
        root.children.add(tigerHeadPane)
        tigerHead.setBound(0.0,width-tigerHeadScale,0.0,height-tigerHeadScale)
    }

    fun setupPresentation(folder:File): Presentation {
        presentation = Presentation(width,height,folder)
        presentationRoot = presentation.rootPane
        contentPane.children.addAll(presentationRoot)
        tigerHeadPane.toFront()
        return presentation
    }

    fun nextSlide(){
        presentation.nextSlide()
    }

    fun prevSlide(){
        presentation.prevSlide()
    }



}