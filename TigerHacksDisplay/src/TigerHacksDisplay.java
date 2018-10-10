import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TigerHacksDisplay extends Application {
    Display disp;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDisplay();
        Pane root = disp.getRootPane();


        Scene scene = new Scene(root, disp.getWidth(), disp.getHeight());
        scene.getStylesheets().add("../style.css");

        primaryStage.setTitle("THD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initDisplay(){
        this.disp = new Display();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
