package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage priStage;
        priStage = primaryStage;
        priStage.initStyle(StageStyle.TRANSPARENT);
        priStage.setTitle("MealBarn");
        SceneData.getSceneData().loginScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


