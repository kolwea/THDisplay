import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class TigerHacksDisplay extends Application {
    Display disp;
    JFrame frame;

    @Override
    public void start(Stage primaryStage) throws Exception {
        disp = new Display();
        disp.updateDisplay();
    }

    private void initDisplay(){
        this.disp = new Display();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
