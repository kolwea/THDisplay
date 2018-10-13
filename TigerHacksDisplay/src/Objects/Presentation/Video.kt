package Objects.Presentation

import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

class Video(width:Double, height:Double){

    var player : MediaPlayer = MediaPlayer(Media(javaClass.getResource("video.mp4").toExternalForm()))
    var view : MediaView = MediaView(player)

    init{
        view.fitHeight = height
        view.fitWidth = width
    }


}