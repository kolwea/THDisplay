package Objects.Presentation

import java.io.File


class SlideController(slideFolder:File){


    private var slides : ArrayList<Slide> = ArrayList()
    private var currSlide: Slide?
    private var currSlideIndex : Int


    init {
        currSlideIndex = -1
        currSlide = null
    }

    private fun setupSlides(){

    }

}