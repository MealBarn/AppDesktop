package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< Updated upstream

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

=======
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage priStage;
    public static Scene Login;
    public static Scene Search;
    public static Scene Select;
    public static Scene Category;

    @Override
    public void start(Stage primaryStage) throws Exception{
        priStage = primaryStage;

        Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));  /// 1
        Parent Search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Parent Select = FXMLLoader.load(getClass().getResource("Select.fxml"));
        Parent Category = FXMLLoader.load(getClass().getResource("Category.fxml"));
        this.Login = new Scene(Login); /// 2
        this.Search = new Scene(Search);
        this.Select = new Scene(Select);
        this.Category = new Scene(Category);

//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        priStage.setTitle("MealBarn");
//        primaryStage.setScene(new Scene(root, 300, 275));
        priStage.setScene(this.Login); /// 3
        primaryStage.show();
    }


>>>>>>> Stashed changes
    public static void main(String[] args) {
        launch(args);
    }
}
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
