package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class ShowFoodController {

    @FXML
    private Text foodName;

    @FXML
    private ImageView foodImg;

    @FXML
    private ImageView imgDetail;

    @FXML
    private JFXButton prevButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private JFXButton ingButton;

    @FXML
    private JFXButton dirButton;

    @FXML
    private ImageView closeButton;

    @FXML
    void categoryPage(ActionEvent event) throws IOException {
        SceneCategory();
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void dirMode(ActionEvent event) {
        String sorceD = "./img/Alacarte/2.png";
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
        ingButton.setDisable(false);
        dirButton.setDisable(true);
    }

    @FXML
    void ingMode(ActionEvent event) {
        String sorceD = "./img/Alacarte/1.png";
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
        ingButton.setDisable(true);
        dirButton.setDisable(false);
    }

    @FXML
    void nextPage(ActionEvent event) {

    }

    @FXML
    void prevPage(ActionEvent event) {

    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        SceneSearch();
    }

    Data data = Data.getData();

    @FXML
    void initialize() {
        int idFood = data.getIdFood();
        FoodShow food1 = data.getFoodShowsList().get(idFood);
        foodName.setText(food1.getName());
        String sorceF = "./img/Alacarte/1.png";
        Image imageF = new Image(sorceF);
        foodImg.setImage(imageF);
        String sorceD = "./img/Alacarte/1.png";
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
        ingButton.setDisable(true);
    }

    private void SceneCategory() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent result = FXMLLoader.load(getClass().getResource("Category.fxml"));
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
    }

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(search);
        stage.setScene(scene);
        stage.show();
    }

}
