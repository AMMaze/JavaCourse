package Lesson_7.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Chat 2k19");
        Scene scene = new Scene(root, 310, 350);

        primaryStage.setOnCloseRequest(e -> {
            Controller handle = loader.getController();
            try {
                handle.out.writeUTF("/end");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
