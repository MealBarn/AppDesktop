package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage priStage;
        priStage = primaryStage;
        Parent LoginP = FXMLLoader.load(getClass().getResource("Login.fxml"));  /// 1
        Scene Login = new Scene(LoginP); /// 2
        priStage.setTitle("MealBarn");
        priStage.setScene(Login); /// 3
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


