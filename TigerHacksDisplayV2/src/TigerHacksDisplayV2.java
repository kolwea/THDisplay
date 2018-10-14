import Background.HexGrid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TigerHacksDisplayV2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        double width = 900.0;
        double height = 650.0;

        HexGrid grid = new HexGrid(width,height,20.0,true);
        Pane rootPane = grid.getRoot();
        Scene scene = new Scene(rootPane,width,height);
        scene.getStylesheets().add("/Stylesheets/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
