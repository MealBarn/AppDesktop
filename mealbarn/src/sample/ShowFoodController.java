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
        pageSize = sizeDir;
        page = 1;
        mode = 2;
        setImg();
        updateButton();
        ingButton.setDisable(false);
        dirButton.setDisable(true);
    }

    @FXML
    void ingMode(ActionEvent event) {
        pageSize = sizeIng;
        page =1;
        mode = 1;
        setImg();
        updateButton();
        ingButton.setDisable(true);
        dirButton.setDisable(false);
    }

    @FXML
    void nextPage(ActionEvent event) {
        page++;
        setImg();
        updateButton();
    }

    @FXML
    void prevPage(ActionEvent event) {
        page--;
        setImg();
        updateButton();
    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        SceneSearch();
    }

    Data data = Data.getData();
    Integer[] recipeIng = data.getRecipeIng();
    Integer[] recipeDir = data.getRecipeDir();
    int idFood = data.getIdFood();
    int sizeIng = recipeIng[idFood];
    int sizeDir = recipeDir[idFood];
    int pageSize;
    int page;
    int mode;

    void updateButton(){
        if(page==1){
            prevButton.setVisible(false);
        }else {
            prevButton.setVisible(true);
        }
        if(page==pageSize){
            nextButton.setVisible(false);
        }else {
            nextButton.setVisible(true);
        }
    }

    void setImg(){
        String sorceD = String.format("./img/foodRecipe/%d-%d-%d.png",idFood+1,mode,page);
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
    }

    @FXML
    void initialize() {
        page = 1;
        pageSize = sizeIng;
        mode = 1;
        System.out.println(String.format("%d\t%d\t%d",idFood,sizeIng,sizeDir));
        FoodShow food1 = data.getFoodShowsList().get(idFood);
        foodName.setText(food1.getName());
        String sorceF = String.format("./img/imgFood/%d.png",idFood+1);
        Image imageF = new Image(sorceF);
        foodImg.setImage(imageF);
        setImg();
        updateButton();
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
