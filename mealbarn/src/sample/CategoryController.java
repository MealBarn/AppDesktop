package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {

    @FXML
    private ImageView closeButton;

    @FXML
    void alacarteSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getAlacateIDList());
        tempData.setPage(0);
        tempData.setType("Alacarte");
        SceneResult();
    }

    @FXML
    void appetizerSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getAppetizerIDList());
        tempData.setPage(0);
        tempData.setType("Appetizer");
        SceneResult();
    }

    @FXML
    void closeButtonAction (MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void dessertSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getDessertIDList());
        tempData.setPage(0);
        tempData.setType("Dessert");
        SceneResult();
    }

    @FXML
    void drinkSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getDrinkIDList());
        tempData.setPage(0);
        tempData.setType("Drink");
        SceneResult();
    }

    @FXML
    void maincourseSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getMainCourseIDList());
        tempData.setPage(0);
        tempData.setType("Maincourse");
        SceneResult();
    }

    @FXML
    void soupSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getSoupIDList());
        tempData.setPage(0);
        tempData.setType("Soup");
        SceneResult();
    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        SceneSearch();
    }

    FoodData foodData = FoodData.getFoodData();
    TempData tempData = TempData.getTempData();

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(search);
        stage.setScene(scene);
        stage.show();
    }

    private void SceneResult() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent result = FXMLLoader.load(getClass().getResource("CategoryResult.fxml"));
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
    }

}
