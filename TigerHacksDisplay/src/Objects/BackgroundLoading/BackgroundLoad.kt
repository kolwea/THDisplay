package Objects.BackgroundLoading

import Base.NodePoints
import Objects.Point
import Tools.Tools.Functions
import Tools.Tools.OpenSimplexNoise
import javafx.scene.layout.Pane
import javafx.scene.paint.Color

class BackgroundLoad(var width : Double, var height : Double){

    var connectRadius = 60.0
    val nodePadding = 45.0
    val pointCount = 200
    var nodes = NodePoints(width, height)
    var rootPane : Pane = Pane()

    var updateCount = 0.0

    val nodeStyle = arrayOf(5.0,Color.WHEAT,Color.RED,1.0)

    init{
        rootPane = Pane()
        initPane()
        setupPoints()
    }

    private fun initPane(){
        rootPane.setPrefSize(width,height)
        rootPane.styleClass.add("TH-Black")
    }

//    private fun buildBackground(){
//        var pathRectangle = Rectangle()
//        pathRectangle.width = width
//        pathRectangle.height = height
//    }

    private fun setupPoints(){
        nodes.setStyle(nodeStyle[0] as Double, nodeStyle[1] as Color, nodeStyle[2] as Color, nodeStyle[3] as Double)
        nodes.createPoints(pointCount)
        nodes.addPointsToPane(rootPane)
        nodes.setRandomPositionsNoTouch(width,height,nodePadding)
        nodes.map(this::findNeighbors)
        nodes.connectPoints()
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

    fun update(){
        updateCount++
        for(point in nodes.points){
            updateFlowfield(point)
        }
    }

    fun updateFlowfield(point : Point){
        var x = point.xPos
        var y = point.yPos
        var z = this.updateCount

        var simplex = OpenSimplexNoise()

        var flow = simplex.eval(x,y,z)
        var translateVal = Functions.map(flow,-1.0,1.0,-20.0,20.0)

        if(point.index == 0)
            println("X: $x  Y:$y TrasVal: $translateVal")

        point.setPosition(x+translateVal,y)
        point.body.translateX = x + translateVal
        point.body.translateY  = y
        point.update()
    }
}