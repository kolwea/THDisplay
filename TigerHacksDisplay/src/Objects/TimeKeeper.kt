package Objects

import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.util.Duration

class TimeKeeper {

    lateinit var keyframe : KeyFrame
    lateinit var timeline : Timeline
    var count = 0.0

    init {
        setupTimeline()
    }

    fun start(){

    }

    private fun setupTimeline() {
        var event = EventHandler<ActionEvent> {update()}
        keyframe = KeyFrame(Duration.millis(10.0),event)
        timeline = Timeline(keyframe)
        timeline.setCycleCount(Animation.INDEFINITE)
        timeline.play()
    }

    private fun update() {
//        println(count++)
    }
}