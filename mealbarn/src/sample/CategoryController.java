package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {
	
	@FXML
    private Text accountName;

    @FXML
    private ImageView closeButton;

    @FXML
    void alacarteSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getAlacateIDList());
        tempData.setPage(0);
        tempData.setType("Alacarte");
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
    }

    @FXML
    void appetizerSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getAppetizerIDList());
        tempData.setPage(0);
        tempData.setType("Appetizer");
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
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
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
    }

    @FXML
    void drinkSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getDrinkIDList());
        tempData.setPage(0);
        tempData.setType("Drink");
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
    }

	@FXML
    void logoutAction(ActionEvent event) throws IOException {
        tempData.setAccount(null);
        tempData.setIdAccount(null);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().loginScene(stage);
    }

    @FXML
    void maincourseSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getMainCourseIDList());
        tempData.setPage(0);
        tempData.setType("Maincourse");
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
    }

	@FXML
    void searchPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().searchScene(stage);
    }

    @FXML
    void soupSelect(ActionEvent event) throws IOException {
        tempData.setShowIDList(foodData.getSoupIDList());
        tempData.setPage(0);
        tempData.setType("Soup");
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultCategoryScene(stage);
    } 
    
    @FXML
    void initialize() {
        accountName.setText(tempData.getAccount());
    }

    private FoodData foodData = FoodData.getFoodData();
    private TempData tempData = TempData.getTempData();

}
