package Background

import Tools.Functions
import Tools.HexGlass
import Tools.OpenSimplexNoise
import Tools.Point
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import java.awt.Panel

class FlowField(var width: Double, var height: Double) {

    val extraPoints = 10.0
    val nudgeH = 0.0
    val nudgeV = 0.0
    var countChange = .01
    var count = 0.0
    val flowScale = 10
    val flowMin = 0.0
    val flowMax = 20.0

    val pointStrokeWidth = 2.0
    val pointStroke = Color.BLACK
    val pointColor = Color.RED


    var root = Pane()
    var scale = 50.0
    var padding = 0.80
    var points = arrayListOf<Point>()

    private val rows = Array<Double>(getRowCount()) { 0.0 }
    private val cols = Array<Double>(getColumnCount()) { 0.0 }

    init {
        root.setPrefSize(width, height)

        setupPoints()
        addPoints()
    }

    fun setupPoints() {
        for (r in 0 until getRowCount()) {
            for (c in 0 until getColumnCount()) {
                cols[c] = (c * scale) + nudgeH
                rows[r] = (r * scale) + nudgeV
            }
        }
        for (r in 0 until rows.size) {
            for (c in 0 until cols.size) {
                if (c % 2 == 0) {
                    points.add(Point(cols[c],rows[r],scale*padding,pointColor,pointStroke,pointStrokeWidth.toDouble()))
                } else {
                    points.add(Point(cols[c],rows[r] + scale/2 ,scale*padding,pointColor,pointStroke,pointStrokeWidth.toDouble()))
                }
            }
        }
    }

    private fun getRowCount(): Int {
        return ((height / scale).toInt() + extraPoints).toInt()
    }

    private fun getColumnCount(): Int {
        return ((width / scale).toInt() + extraPoints).toInt()
    }

    private fun addPoints(){
        for(point in points)
            root.children.addAll(point.body)
    }

    fun update(){
        for (point in points){
            updateNoiseField(point)
        }
        count+=countChange
    }

    fun updateNoiseField(point: Point) {
        val x = point.x
        val y = point.y
        val z = count

        val simplex = OpenSimplexNoise()

        val noiseVal = simplex.eval(x  * this.flowScale , y * flowScale , z )

        val newY = Functions.map(noiseVal*10, -10.0, 10.0,  this.flowMin, this.flowMax)

        point.setPosition(x,y+newY)
    }

}
