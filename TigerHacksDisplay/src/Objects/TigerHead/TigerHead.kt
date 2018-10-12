package Objects.TigerHead

import Objects.Background.Hexagon
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle

class TigerHead(var scale :Double) {

    val tigerLogoPicture: Image?
    var tigerLogo: ImageView
    var rootPane: StackPane = StackPane()


    val hexSize = scale/2 + 25.0

    val boarderRadius = scale/2
    var logoBorder: Circle = Circle()
    var hexBoarder: Hexagon

    init {
        rootPane.setPrefSize(scale, scale)

        hexBoarder = Hexagon(rootPane.width / 2, rootPane.height / 2, hexSize)
        hexBoarder.fill = Color.valueOf("#FEF8E2")
        hexBoarder.strokeWidth = 5.0
        hexBoarder.stroke = Color.valueOf("#333132")
        hexBoarder.updateBody()
        rootPane.children.addAll(hexBoarder.body)

        logoBorder.radius = boarderRadius + 7.0
        logoBorder.fill = Color.valueOf("#F8993A80")
        logoBorder.stroke = Color.valueOf("#333132")
        logoBorder.strokeWidth = 4.0
        rootPane.children.add(logoBorder)

        tigerLogoPicture = Image("Objects/TigerHead/Orange.png",scale,scale,true,true)
        tigerLogo = ImageView(tigerLogoPicture)
        rootPane.children.add(tigerLogo)
    }

}