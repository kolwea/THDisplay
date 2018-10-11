import Objects.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

import static sun.misc.Version.println;

public class TigerHacksDisplay extends Application {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane rootPane = new Pane();
        controller = new Controller(rootPane);
        controller.addCircle();
        controller.start();

        Scene scene = new Scene(rootPane,controller.getWidth(),controller.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
