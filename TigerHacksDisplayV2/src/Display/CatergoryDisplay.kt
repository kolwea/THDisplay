package Display

import javafx.scene.control.Label
import javafx.scene.effect.DropShadow
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color

class CatergoryDisplay( title:String,var width:Double,var height:Double) {
    val rootPane = BorderPane()
    val titlePane = HBox()
    val contentPane = VBox()



    val catergory = title
    val catergoryField = Label()
    val dropShadow = DropShadow()

    init {
        dropShadow.setRadius(6.0)
        dropShadow.setOffsetX(3.0)
        dropShadow.setOffsetY(3.0)
        dropShadow.setColor(Color.valueOf("#00000093"))

        setupRootPane()
        setupTitlePane()
        setupContentPane()
    }

    fun setupRootPane() {
        rootPane.styleClass.add("catergory-display-root")
        rootPane.setPrefSize(width,height)
        rootPane.center = contentPane
        rootPane.top = titlePane
        rootPane.effect = dropShadow
    }

    fun setupTitlePane() {
        titlePane.styleClass.add("catergory-display-title")
        titlePane.children.addAll(catergoryField)
        catergoryField.text = catergory
        catergoryField.styleClass.add("catergory-title-text")
    }

    fun setupContentPane() {
        contentPane.styleClass.add("catergory-display-content")
    }

    fun setStyleClass(index:Int){
        if(index==0){
            rootPane.styleClass.addAll("catergory-display0-rootPane")
            rootPane.styleClass.addAll("catergory-display0-title")
            rootPane.styleClass.addAll("catergory-display0-content")
        }
        if(index==1){
            rootPane.styleClass.addAll("catergory-display1-rootPane")
            rootPane.styleClass.addAll("catergory-display1-title")
            rootPane.styleClass.addAll("catergory-display1-content")
        }
        if(index==2){
            rootPane.styleClass.addAll("catergory-display2-rootPane")
            rootPane.styleClass.addAll("catergory-display2-title")
            rootPane.styleClass.addAll("catergory-display2-content")
        }
    }


}