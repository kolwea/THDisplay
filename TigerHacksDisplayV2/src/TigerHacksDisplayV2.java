import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TigerHacksDisplayV2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller displayController = new Controller(primaryStage);
        displayController.start();



    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
