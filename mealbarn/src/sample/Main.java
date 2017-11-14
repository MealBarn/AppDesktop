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
    public static Scene Select;
    public static Scene Category;
    public static Scene ResultSearch;

    @Override
    public void start(Stage primaryStage) throws Exception{
        priStage = primaryStage;

        Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));  /// 1
        Parent Search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Parent Select = FXMLLoader.load(getClass().getResource("Select.fxml"));
        Parent Category = FXMLLoader.load(getClass().getResource("Category.fxml"));
        Parent ResultSearch = FXMLLoader.load(getClass().getResource("ResultSearch.fxml"));
        this.Login = new Scene(Login); /// 2
        this.Search = new Scene(Search);
        this.Select = new Scene(Select);
        this.Category = new Scene(Category);
        this.ResultSearch = new Scene(ResultSearch);

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
