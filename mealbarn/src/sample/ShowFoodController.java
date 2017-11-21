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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;
import ooad.ImageSize;

import java.io.IOException;
import java.util.List;

public class ShowFoodController {

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXButton dirButton;

    @FXML
    private Text foodName;

    @FXML
    private ImageView foodImg;

    @FXML
    private ImageView imgDetail;

    @FXML
    private JFXButton ingButton;

    @FXML
    private JFXButton prevButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private ImageView prevImg;

    @FXML
    private ImageView nextImg;

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

    @FXML
    void initialize() {
        page = 1;
        pageSize = sizeIng;
        mode = 1;
        FoodShow food1 = foodData.getFoodShowsList().get(idFood);
        foodName.setText(food1.getName());
        String sorceF = String.format("./img/imgFood/%d.png",idFood+1);
        Image imageF = new Image(sorceF);
        foodImg.setImage(imageF);
        setImg();
        updateButton();
        ingButton.setDisable(true);
    }

    FoodData foodData = FoodData.getFoodData();
    List<ImageSize> imageSizeList = foodData.getImageSizeList();
    int idFood = foodData.getIdFood();
    int sizeIng = imageSizeList.get(idFood).getImgSize();
    int sizeDir = imageSizeList.get(idFood).getDirSize();
    int pageSize;
    int page;
    int mode;

    void updateButton(){
        if(page==1){
            prevButton.setVisible(false);
            prevImg.setVisible(false);
        }else {
            prevButton.setVisible(true);
            prevImg.setVisible(true);
        }
        if(page==pageSize){
            nextButton.setVisible(false);
            nextImg.setVisible(false);
        }else {
            nextButton.setVisible(true);
            nextImg.setVisible(true);
        }
    }

    void setImg(){
        String sorceD = String.format("./img/foodRecipe/%d-%d-%d.png",idFood+1,mode,page);
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
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
