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
        controller = new Controller();
        Pane rootPane = controller.getRootPane();
        controller.addCircle();
        controller.start();

        Scene scene = new Scene(rootPane,controller.getWidth(),controller.getHeight());
        scene.getStylesheets().add("/Stylesheets/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
