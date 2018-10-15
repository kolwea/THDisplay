package Display

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.effect.DropShadow
import javafx.scene.layout.*
import javafx.scene.paint.Color

class CatergoryDisplay(title: String, var width: Double, var height: Double) {
    val rootPane = GridPane()
    val titlePane = HBox()
    val contentPane = VBox()
    val topTeams = GridPane()
    val topTeamNames = arrayOf("a", "b","c")
    var winner = ""
    var winnerDesc = ""

    val catergory = title
    val catergoryField = Label()
    val desc = Label()
    val dropShadow = DropShadow()

    init {
        dropShadow.setRadius(6.0)
        dropShadow.setOffsetX(3.0)
        dropShadow.setOffsetY(3.0)
        dropShadow.setColor(Color.valueOf("#00000093"))

        catergoryField.styleClass.addAll("catergory-label")

        setupRootPane()
        setupTitlePane()
        setupContentPane()
    }

    fun setupRootPane() {
        rootPane.styleClass.add("catergory-display-root")
        rootPane.setPrefSize(width, height)

        var colCon1 = ColumnConstraints()
        colCon1.percentWidth = 10.0

        var colCon2 = ColumnConstraints()
        colCon2.percentWidth = 80.0

        var colCon3 = ColumnConstraints()
        colCon3.percentWidth = 10.0

//        var colConC = ColumnConstraints()
//        colConC.percentWidth = 80.0

        var rowCon1 = RowConstraints()
        rowCon1.percentHeight = 10.0

        var rowCon2 = RowConstraints()
        rowCon2.percentHeight = 10.0

        var rowCon3 = RowConstraints()
        rowCon3.percentHeight = 80.0


        rootPane.columnConstraints.addAll(colCon1, colCon2, colCon3)
        rootPane.rowConstraints.addAll(rowCon1, rowCon2, rowCon3)

        rootPane.add(contentPane, 1, 0, 2, 3)
        rootPane.add(titlePane, 0, 1, 3, 1)

        rootPane.effect = dropShadow
    }

    fun setupTitlePane() {
        titlePane.styleClass.add("catergory-display-title")
        titlePane.children.addAll(catergoryField)
        titlePane.setPrefSize(width, height / 9)
        catergoryField.text = catergory
        catergoryField.styleClass.add("catergory-title-text")
    }

    fun setupContentPane() {
        contentPane.styleClass.add("catergory-display-content")
        contentPane.children.addAll(desc)
        contentPane.setPrefSize(width*.8,height)
        desc.isWrapText = true
        contentPane.spacing = 100.0
        setupWinners()
//        setTopTeams()
        contentPane.children.addAll(topTeams)
    }

    fun setupDescription(){
        val warpper = HBox()
    }

    fun setStyleClass(index: Int) {
        if (index == 0) {
            rootPane.styleClass.addAll("catergory-display0-rootPane")
            titlePane.styleClass.addAll("catergory-display0-title")
            contentPane.styleClass.addAll("catergory-display0-content")
        }
        if (index == 1) {
            rootPane.styleClass.addAll("catergory-display1-rootPane")
            titlePane.styleClass.addAll("catergory-display1-title")
            contentPane
                    .styleClass.addAll("catergory-display1-content")
        }
        if (index == 2) {
            rootPane.styleClass.addAll("catergory-display2-rootPane")
            titlePane.styleClass.addAll("catergory-display2-title")
            contentPane.styleClass.addAll("catergory-display2-content")
        }
    }

    fun setDescription(index: Int) {
        if (index == 0) {
            desc.text = "Prizes in this category are given to groups of more seasoned hackathon-goers who have created a stellar project."
        }
        if (index == 1) {
            desc.text = "Prizes in this category are given to groups who are attending their first hackathon and have proven thomselves with well-designed projects."
        }
        if (index == 2) {
            desc.text = "Prizes in this category are given to groups who have outdone themselves on the business side of things. Above-average organization and presentation skills are rewarded."
        }
    }

    fun setTopTeams() {
        var i = 0
        for (name in topTeamNames) {
            val box = HBox()
            box.styleClass.addAll("top-team-wrapper")
            box.minWidth = 320.0
            val viewPane = HBox()
            viewPane.styleClass.add("top-team-view")
            viewPane.minWidth = 3200.0
            viewPane.alignment = Pos.CENTER
            viewPane.effect = dropShadow
            val teamName = Label(name)
            teamName.styleClass.add("top-team-label")

            box.setPrefSize(width,height*.1)

            box.children.addAll(viewPane)
            viewPane.children.addAll(teamName)

            topTeams.add(box, 0, i)
            i++
        }

    }

    fun setupWinner(){
        val pane = GridPane()
        pane.setPrefSize(350.0,350.0)
        val winnerLabelWrapper = HBox()
        winnerLabelWrapper.alignment = Pos.CENTER
        val winnerLabel = Label(winner)
        val descLabelWrapper = HBox()
        val descLabel = Label(winnerDesc)

        winnerLabelWrapper.styleClass.addAll("winner-label-wrapper")
        descLabelWrapper.styleClass.addAll("winner-label-wrapper")

        winnerLabelWrapper.children.addAll(winnerLabel)


        var colCon1 = ColumnConstraints()
        colCon1.percentWidth = 10.0

        var colCon2 = ColumnConstraints()
        colCon2.percentWidth = 80.0

        var colCon3 = ColumnConstraints()
        colCon3.percentWidth = 10.0

//        var colConC = ColumnConstraints()
//        colConC.percentWidth = 80.0

        var rowCon1 = RowConstraints()
        rowCon1.percentHeight = 10.0

        var rowCon2 = RowConstraints()
        rowCon2.percentHeight = 10.0

        var rowCon3 = RowConstraints()
        rowCon3.percentHeight = 80.0


        pane.columnConstraints.addAll(colCon1, colCon2, colCon3)
        pane.rowConstraints.addAll(rowCon1, rowCon2, rowCon3)

        pane.add(winnerLabelWrapper,1,1,3,1)

    }


}