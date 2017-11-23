package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneData {
    private static SceneData sceneData = new SceneData();
    private SceneData(){

    }
    
    public void backScene(Stage stage,String mode) throws IOException {
        Parent result;
        if(mode.compareTo("Category")==0) {
            result = FXMLLoader.load(getClass().getResource("ResultCategory.fxml"));
        }
        else {
            result = FXMLLoader.load(getClass().getResource("ResultSearch.fxml"));
        }
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
    }

    public void categoryScene(Stage stage) throws IOException {
        Parent category = FXMLLoader.load(getClass().getResource("Category.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(category);
        stage.setScene(scene);
        stage.show();
    }

	public static SceneData getSceneData(){
        return sceneData;
    }

	public void loginScene(Stage stage) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(login);
        stage.setScene(scene);
        stage.show();
    }

    public void resultCategoryScene(Stage stage) throws IOException {
        Parent resultcategory = FXMLLoader.load(getClass().getResource("ResultCategory.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(resultcategory);
        stage.setScene(scene);
        stage.show();
    } 

    public void resultSearchScene(Stage stage) throws IOException {
        Parent resultSearch = FXMLLoader.load(getClass().getResource("ResultSearch.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(resultSearch);
        stage.setScene(scene);
        stage.show();
    }

    public void searchScene(Stage stage) throws IOException {
        Parent search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(search);
        stage.setScene(scene);
        stage.show();
    }

    public void showFoodScene(Stage stage) throws IOException {
        Parent showFood = FXMLLoader.load(getClass().getResource("ShowFood.fxml"));
        javafx.scene.Scene scene = new javafx.scene.Scene(showFood);
        stage.setScene(scene);
        stage.show();
    }
}
