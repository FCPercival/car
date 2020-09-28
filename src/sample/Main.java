package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ui_javafx.fxml"));
        primaryStage.setTitle("Car Alpha");
        Image image=new Image("sample/image.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(new Scene(root, 960, 575));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
