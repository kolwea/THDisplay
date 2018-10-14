import Background.BackgroundHex;
import Background.HexGrid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TigerHacksDisplayV2 extends Application {
//    Controller controller;
//    Scene scene;
//    Stage prime;
//    Pane rootPane;
//
//    int startCount;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        controller = new Controller();
//        rootPane = controller.getRootPane();
////        controller.addCircle();
//        startCount = 0;
//
//
//
//        addButtons();
//
//        prime = primaryStage;
//        scene = new Scene(rootPane, controller.getWidth(), controller.getHeight());
//        controller.setup();
//        controller.start();
//        setupKeys(scene);
//        scene.getStylesheets().add("/Stylesheets/style.css");
//        primaryStage.setScene(scene);
//        primaryStage.setMaximized(true);
//        primaryStage.setFullScreen(true);
//        primaryStage.show();
        double width = 800.0;
        double height = 500.0;

//        BackgroundHex background = new BackgroundHex(width,height);
        HexGrid grid = new HexGrid(width,height,20.0,true);
        Pane rootPane = grid.getRoot();
        Scene scene = new Scene(rootPane,width,height);
        scene.getStylesheets().add("/Stylesheets/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

//    public void addButtons() {
//        Button fileButton = new Button("Choose Folder");
//        Button start = new Button("Start Idle");
//
//        fileButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                File file = null;
//                try {
//                    DirectoryChooser chooser = new DirectoryChooser();
//                    chooser.setTitle("Choose Folder");
//                    File defaultDirectory = new File("./TigerHacksDisplayV2/src/Objects/Presentation");
//                    chooser.setInitialDirectory(defaultDirectory);
//                    File selectedDirectory = chooser.showDialog(prime);
//                    controller.setFile(selectedDirectory);
//                } catch (
//                        Exception e)
//
//                {
//
//                }
//                rootPane.getChildren().remove(fileButton);
//            }
//        });
//        rootPane.getChildren().add(fileButton);
//    }
//
//    public void setupKeys(Scene scene) {
//        scene.setOnKeyPressed(new javafx.event.EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.SPACE || event.getCode() == KeyCode.RIGHT) {
//                    if(startCount == 0){
//                        controller.addContent();
////                        controller.stopHead();
//                        startCount++;
//                    }
//                    else {
//                        controller.nextSlide();
//                    }
//                }
//                if (event.getCode() == KeyCode.LEFT) {
//                    controller.prevSlide();
//                }
//            }
//        });
//    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
