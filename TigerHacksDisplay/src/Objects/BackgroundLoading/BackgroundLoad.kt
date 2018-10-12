package Objects.BackgroundLoading

import Objects.NodePoints
import Objects.Point
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class BackgroundLoad(var width : Double, var height : Double){

    var connectRadius = 60.0
    val nodePadding = 45.0
    val count = 200
    var nodes = NodePoints(width,height)
    var rootPane : Pane = Pane()

    val nodeStyle = arrayOf(5.0,Color.WHEAT,Color.RED,1.0)

    init{
        rootPane = Pane()
        initPane()
        setupPoints()
//        buildBackground()
    }

    private fun initPane(){
        rootPane.setPrefSize(width,height)
        rootPane.styleClass.add("TH-Black")
    }

    private fun buildBackground(){
        var pathRectangle = Rectangle()
        pathRectangle.width = width
        pathRectangle.height = height
    }

    private fun setupPoints(){
        nodes.setStyle(nodeStyle[0] as Double, nodeStyle[1] as Color, nodeStyle[2] as Color, nodeStyle[3] as Double)
        nodes.createPoints(count)
        nodes.addPointsToPane(rootPane)
        nodes.setRandomPositionsNoTouch(width,height,nodePadding)
        nodes.map(this::findNeighbors)
        nodes.connectPoints()
        println(nodes.connex.size)
        rootPane.children.addAll(nodes.connex)
        for(line in nodes.connex)
            line.toBack()
    }
    fun findNeighbors(point : Point){
        var hold = point.radius
        point.radius = connectRadius
        point.update()
        for (point in nodes.points){
            for(pointTouch in nodes.points){
                if(nodes.pointsIntersect(point,pointTouch)){
                    point.addNeighbor(pointTouch)
                }
            }
        }
        point.radius = hold
        point.update()
        println(point.neighbors.size)
    }

}