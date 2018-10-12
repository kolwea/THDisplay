package Objects.Presentation

import javafx.scene.image.Image
import javafx.scene.layout.Pane
import java.io.File


class SlideController(var slideFolder: File, var width: Double, var height: Double) {


    var slides: ArrayList<Slide> = ArrayList<Slide>()
    var pane: Pane = Pane()
    private var currSlide: Slide?
    private var currSlideIndex: Int



    init {
        currSlideIndex = -1
        currSlide = null
    }


    fun setupSlides() {
        createSlides()
        connectSlides()
    }

    private fun connectSlides(){
        for(i in 0 until slides.size){
            var curr = slides[i]
            curr.index = i;
            if(i-1>=0)
                curr.setPrevSlide(slides[i-1])
            if(i+1 < slides.size)
                curr.setNextSlide(slides[i+1])
        }
        for(slide in slides)
            println(slide.index)
    }

    private fun createSlides(){
        var ext = arrayOf("jpg", "jpeg", "png", "PNG")

        fun getExtension(f: File): String {
            var ext: String
            var s = f.getName();
            var i = s.lastIndexOf('.');

            if (i > 0 && i < s.length - 1) {
                ext = s.substring(i + 1).toLowerCase()
            } else
                ext = ""
            return ext;
        }

        for (file in slideFolder.listFiles()) {
            val extension = getExtension(file)
            if (extension != null) {
                for (exten in ext) {
                    if (extension.contains(exten)) {
                        var image = Image(file.toURI().toString(),1400.0,0.0,true,true)
                        var slide = Slide(image)
                        slides.add(slide)
                    }

                }
            }
        }
    }


}