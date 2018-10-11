import Objects.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

import static sun.misc.Version.println;

public class TigerHacksDisplay extends Application {
    Display disp;
    Controller cont;

    @Override
    public void start(Stage primaryStage) throws Exception {
        disp = new Display();
        disp.updateDisplay();

        Scene scene = disp.getPanel().getScene();
        primaryStage.setScene(scene);
        primaryStage.show();

        cont = new Controller(disp.getRoot());
        cont.start();
    }

    private void initDisplay(){
        this.disp = new Display();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
