import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class TigerHacksDisplay extends Application {
    Display disp;
    JFrame frame;
    JFXPanel panel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDisplay();
        frame.setVisible(true);

        Scene scene = panel.getScene();
        scene.getStylesheets().add("../style.css");

        primaryStage.setTitle("THD");
        primaryStage.setScene(scene);
        primaryStage.show();

        disp.updateDisplay();
    }

    private void initDisplay(){
        this.disp = new Display();
        this.frame = disp.getFrame();
        this.panel = disp.getPanel();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
