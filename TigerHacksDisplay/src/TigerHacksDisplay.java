import Objects.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.beans.EventHandler;
import java.io.File;

public class TigerHacksDisplay extends Application {
    Controller controller;
    Scene scene;
    Stage prime;
    Pane rootPane;

    int startCount;

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        rootPane = controller.getRootPane();
//        controller.addCircle();
        startCount = 0;

        addButtons();

        prime = primaryStage;
        scene = new Scene(rootPane, controller.getWidth(), controller.getHeight());
        setupKeys(scene);
        scene.getStylesheets().add("/Stylesheets/style.css");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        controller.setup();
        controller.start();

    }

    public void addButtons() {
        Button fileButton = new Button("Choose Folder");
        Button start = new Button("Start Idle");

        fileButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = null;
                try {
                    DirectoryChooser chooser = new DirectoryChooser();
                    chooser.setTitle("Choose Folder");
                    File defaultDirectory = new File("./TigerHacksDisplay/src/Objects/Presentation");
                    chooser.setInitialDirectory(defaultDirectory);
                    File selectedDirectory = chooser.showDialog(prime);
                    controller.setFile(selectedDirectory);
                } catch (
                        Exception e)

                {

                }
                rootPane.getChildren().remove(fileButton);
            }
        });
        rootPane.getChildren().add(fileButton);
    }

    public void setupKeys(Scene scene) {
        scene.setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE || event.getCode() == KeyCode.LEFT) {
                    if(startCount == 0){
                        controller.addContent();
//                        controller.stopHead();
                        startCount++;
                    }
                    else {
                        controller.nextSlide();
                    }
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    controller.prevSlide();
                }
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
