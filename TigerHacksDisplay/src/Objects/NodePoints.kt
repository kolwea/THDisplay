package Objects

import javafx.scene.layout.Pane

class NodePoints() {

    var width = 0.0
    var height = 0.0
    var points: Array<Point?> = arrayOf<Point?>()
    val size = 100;

    init {
        points = arrayOfNulls<Point>(size)
        points.fill(Point(), 0, size)
        for (i in 0..size - 1) {
            var point = points.get(i)
            point?.index = i
            println(point?.index)
        }
    }

    fun setPane(rootPane: Pane?) {
        if (rootPane != null) {
            for (point in points) {
                rootPane?.children.remove(point?.body)
                rootPane?.children.add(point?.body)
            }
            width = rootPane.width
            height = rootPane.height
            println("Pane set for points.")
        }
    }

    fun setRandomPositions() {
        for (point in points) {
            point?.setRandomPosition(width, height)
        }
    }


}