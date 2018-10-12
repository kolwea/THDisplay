package Objects.TigerHead

import Objects.Background.Hexagon
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Path

class TigerHead(var scale: Double) {

    val tigerLogoPicture: Image?
    var tigerLogo: ImageView
    var drawPane: StackPane = StackPane()
    var topPane: StackPane = StackPane()
    var rootPane: StackPane = StackPane()


    private var position: Pair<Double, Double>
    private var velocity: Pair<Double, Double>
    private var acceleration: Double
    private var targetPosition: Pair<Double, Double>
    private var pathLength: Double
    private var boundX : Pair<Double, Double>
    private var boundY :Pair<Double, Double>


    val hexSize = scale / 2 + 25.0
    val boarderRadius = scale / 2
    var logoBorder: Circle = Circle()
    var logoBorderRadius = boarderRadius + 7.0
    var hexBoarder: Hexagon

    init {
        position = Pair(0.0, 0.0)
        targetPosition = Pair(300.0, 300.0)
        velocity = Pair(5.0, 5.0)
        acceleration = 0.5
        pathLength = 0.0
        boundX = Pair(0.0,0.0)
        boundY = Pair(0.0,0.0)

        drawPane.setPrefSize(scale, scale)
        topPane.setPrefSize(scale, scale)
        rootPane.setPrefSize(2 * scale, 2 * scale)
        rootPane.children.addAll(topPane, drawPane)

        hexBoarder = Hexagon(rootPane.width / 2, rootPane.height / 2, hexSize)
        hexBoarder.fill = Color.valueOf("#FEF8E2")
        hexBoarder.strokeWidth = 5.0
        hexBoarder.stroke = Color.valueOf("#333132")
        hexBoarder.updateBody()
        topPane.children.addAll(hexBoarder.body)

        logoBorder.radius = logoBorderRadius
        logoBorder.fill = Color.valueOf("#F8993ADE")
        logoBorder.stroke = Color.valueOf("#333132")
        logoBorder.strokeWidth = 4.0
        drawPane.children.add(logoBorder)

        tigerLogoPicture = Image("Objects/TigerHead/Orange.png", scale, scale, true, true)
        tigerLogo = ImageView(tigerLogoPicture)
        drawPane.children.add(tigerLogo)

        clipChildren()
    }

    fun clipChildren() {
        var outputClip = Circle()
        var coverClip = Circle()
        rootPane.clip = coverClip
        outputClip.radius = logoBorderRadius
        coverClip.radius = 100.0

        outputClip.centerX = rootPane.prefWidth / 2
        outputClip.centerY = rootPane.prefHeight / 2

        coverClip.centerX = rootPane.prefWidth / 2
        coverClip.centerY = rootPane.prefHeight / 2

        topPane.clip = Path.subtract(coverClip, outputClip)
    }

    fun setPosition(x: Double, y: Double) {
        position = Pair(x, y)
    }

    fun getPosition():Pair<Double,Double>{
        return position
    }

    fun setBound(xMin : Double,xMax : Double,yMin : Double,yMax: Double){
        this.boundX = Pair(xMin,xMax)
        this.boundY = Pair(yMin,yMax)
    }

    fun update():Pair<Double,Double> {
        var x = position.first + drawPane.prefWidth/2
        var y = position.second + drawPane.prefHeight/2

        var xV = 0.0
        var yV = 0.0

        if (x <= (boundX.second - drawPane.prefWidth/2) && (x >= boundX.first + drawPane.prefWidth/2 )){
            xV = position.first + velocity.first * acceleration
        }
        else {
            velocity = Pair(-velocity.first, velocity.second)
            xV = position.first + velocity.first * acceleration
        }
        if(y <= (boundY.second - drawPane.prefHeight/2) && (y >= boundY.first + drawPane.prefHeight/2 )) {
            yV = position.second + velocity.second * acceleration
        }
        else {
            velocity = Pair(velocity.first, -velocity.second)
            yV = position.second + velocity.second * acceleration
        }

        position = Pair(xV,yV)
        return position
    }
}