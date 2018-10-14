package Display

import javafx.geometry.Pos
import javafx.scene.layout.*

class Display(private val width: Double, private val height: Double) {
    val displayCount = 3
    val catergories = arrayOf("Developer", "Beginner", "Business")
    val catWidth = width * 0.2
    val catHeight = height * 0.68

    val rootWidth = 0.0
    val rootHeight = 0.0

    val spacer1 = Pane()
    val spacer2 = Pane()
    val spacerWidth = 200.0
    val spacerHeight = 100.0
//    val botWidth = 0.0
//    val botHeight =  0.0
//    val middleWidth = 0.0
//    val middleHeight = 0.0
//    val topWidth = 0.0
//    val topHeight = 0.0


    val root = BorderPane()

    val contentRoot = BorderPane()
    val bottom = HBox()
    val middle = StackPane()
    val catergoryPane = GridPane()

    val catergoryDisplays = ArrayList<CatergoryDisplay>()

    init {
        spacer1.minWidth = spacerWidth
        spacer2.minWidth = spacerWidth
        setupRoot()
        setupContentRoot()
        setupMiddle()
        setupBottom()
    }

    private fun setupRoot() {
        root.setPrefSize(width, height)
        root.styleClass.add("display-root")
        root.center = contentRoot
        root.bottom = bottom
    }

    private fun setupContentRoot() {
        contentRoot.setPrefSize(width, height)
        contentRoot.styleClass.add("contentRoot")
        contentRoot.center = middle
        contentRoot.center.styleClass.add("contentRoot-center")
    }

    fun setupBottom() {
        bottom.styleClass.add("display-bottom")
        bottom.alignment = Pos.BASELINE_RIGHT
    }

    fun setupMiddle() {
        middle.styleClass.add("display-middle")
        setupCatergoryDisplay()
        middle.children.addAll(catergoryPane)
        middle.alignment = Pos.BOTTOM_CENTER


    }

    private fun setupCatergoryDisplay() {
        for (cater in catergories) {
            var hold = CatergoryDisplay(cater, catWidth, catHeight)
            hold.setStyleClass(catergories.indexOf(cater))
            catergoryPane.addColumn(catergories.indexOf(cater), hold.rootPane)
            catergoryPane.alignment = Pos.CENTER
            this.catergoryDisplays.add(hold)
        }

    }
}