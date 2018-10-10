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
        disp.getFrame().setVisible(true);


//        disp.getFrame().setVisible(false);
//        disp.updateDisplay();



//        Scene scene = disp.getPanel().getScene();
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        disp.updateDisplay();
//        disp.initFullscreen();
//        disp.updateDisplay();
//        disp.getFrame().setVisible(true);
    }

    private void initDisplay(){
        this.disp = new Display();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
