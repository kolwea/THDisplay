package Objects.Presentation

import javafx.scene.image.Image
import javafx.scene.layout.Pane
import java.io.File


class SlideController(var slideFolder: File, var width: Double, var height: Double) {


    var slides: ArrayList<Slide> = ArrayList<Slide>()

    fun setupSlides() {
        createSlides()
        connectSlides()
    }

    fun connectSlides(){
        for(i in 0 until slides.size){
            var curr = slides[i]
            if(i-1>=0)
                curr.setPrevSlide(slides[i-1])
            if(i+1 < slides.size)
                curr.setNextSlide(slides[i+1])
            println("Slide: $i")
        }


    }

    fun createSlides(){
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

        for (i in 0 until 38) {
//            if (extension != null) {
//                for (exten in ext) {
//                    if (extension.contains(exten)) {
                        var image = Image(slideFolder.listFiles().get(i).toURI().toString(),1400.0,0.0,true,true)
                        var slide = Slide(image)
            slide.index = i
                        slides.add(slide)
                    }

    }


}