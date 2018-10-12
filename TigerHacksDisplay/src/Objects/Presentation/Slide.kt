package Objects.Presentation

import javafx.scene.image.Image
import javafx.scene.image.ImageView


class Slide(slideImg: Image){

    var slideView : ImageView
    private var nextSlide : Slide?
    private var prevSlide : Slide?
    var index : Int

    init {
        index = -1
        slideView = ImageView(slideImg)
        slideView.styleClass.add("slide-view")
        nextSlide = null
        prevSlide = null
        println("new pic")
    }

    fun setNextSlide(next:Slide){
        nextSlide = next
    }

    fun setPrevSlide(prev:Slide){
        prevSlide = prev
    }

    fun getNextSlide():Slide?{
        return nextSlide
    }

    fun getPrevSlide():Slide?{
        return prevSlide
    }


}