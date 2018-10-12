package Objects.Presentation

import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import java.io.File

class Presentation(var width:Double, var height:Double,var folder : File){

    lateinit var slideController : SlideController

    val rootPane = StackPane()
    val presentPane = VBox()
    val slidePane = StackPane()

    var currSlide : Int

    lateinit var slideHead : Slide



    init{
        currSlide = 0
        rootPane.setPrefSize(width,height)
        rootPane.styleClass.add("presentation-root")

        presentPane.setMaxSize(width,height)

        presentPane.styleClass.add("presentation-content")

        rootPane.children.add(presentPane)

        slideController = SlideController(folder,presentPane.width,presentPane.height)
        presentPane.toFront()
        slideController.setupSlides()
        start()
    }

    fun start(){
        currSlide = 0
        setDisplay()
        slideController.slides[currSlide].slideView.toFront()
    }

    private fun setDisplay(){
        slidePane.setPrefSize(width,height)
        presentPane.children.addAll(slidePane)
        for(slide in slideController.slides){
            slidePane.children.add(slide.slideView)
        }
    }

    fun nextSlide(){
        if(currSlide < slideController.slides.size-1)
            currSlide++
        slideController.slides[currSlide].slideView.toFront()
    }

    fun prevSlide(){
        if(currSlide > 0)
            currSlide--
        slideController.slides[currSlide].slideView.toFront()
    }



}