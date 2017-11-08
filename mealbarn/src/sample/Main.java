package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage priStage;
    public static Scene Login;
    public static Scene Search;

    @Override
    public void start(Stage primaryStage) throws Exception{
        priStage = primaryStage;

        Parent Login = FXMLLoader.load(getClass().getResource("Search.fxml"));  /// 1
//        Parent Search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        this.Login = new Scene(Login); /// 2
        priStage.initStyle(StageStyle.TRANSPARENT);//utt

//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        priStage.setTitle("MealBarn");
//        primaryStage.setScene(new Scene(root, 300, 275));
        priStage.setScene(this.Login); /// 3
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
