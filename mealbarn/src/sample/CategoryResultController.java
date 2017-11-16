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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryResultController {

    @FXML
    private Pane food1;

    @FXML
    private ImageView foodImg1;

    @FXML
    private Text foodName1;

    @FXML
    private Pane food2;

    @FXML
    private ImageView foodImg2;

    @FXML
    private Text foodName2;

    @FXML
    private Pane food3;

    @FXML
    private ImageView foodImg3;

    @FXML
    private Text foodName3;

    @FXML
    private Pane food4;

    @FXML
    private ImageView foodImg4;

    @FXML
    private Text foodName4;

    @FXML
    private Pane food5;

    @FXML
    private ImageView foodImg5;

    @FXML
    private Text foodName5;

    @FXML
    private Pane food6;

    @FXML
    private ImageView foodImg6;

    @FXML
    private Text foodName6;

    @FXML
    private Text pageId;

    @FXML
    private Text recipeCount;

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private JFXButton prevButton;

    int page;
    int size;
    ArrayList<String> idShow;

    Data data = Data.getData();

    @FXML
    void initialize() {
        idShow = data.getShowIDList();
        page = 0;
        size = data.getShowIDList().size();
        recipeCount.setText(String.format("Total %d Recipes",size));
        updateData();
    }

    void updateData(){
        int id;
        int idFood;
        Integer p = page+1;
        String pageNum = p.toString();
        pageId.setText(pageNum);
        ///////////////////////////////////////////--1
        id = (page*6)+0;
        if(id<size) {
            food1.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food1 = data.getFoodShowsList().get(idFood);
            foodName1.setText(food1.getName());
            String sorce1 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image1 = new Image(sorce1);
            foodImg1.setImage(image1);
        }else {
            food1.setVisible(false);
        }
        ///////////////////////////////////////////--2
        id = (page*6)+1;
        if(id<size) {
            food2.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food2 = data.getFoodShowsList().get(idFood);
            foodName2.setText(food2.getName());
            String sorce2 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image2 = new Image(sorce2);
            foodImg2.setImage(image2);
        }else {
            food2.setVisible(false);
        }
        ///////////////////////////////////////////--3
        id = (page*6)+2;
        if(id<size) {
            food3.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food3 = data.getFoodShowsList().get(idFood);
            foodName3.setText(food3.getName());
            String sorce3 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image3 = new Image(sorce3);
            foodImg3.setImage(image3);

        }else {
            food3.setVisible(false);
        }
        ///////////////////////////////////////////--4
        id = (page*6)+3;
        if(id<size) {
            food4.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food4 = data.getFoodShowsList().get(idFood);
            foodName4.setText(food4.getName());
            String sorce4 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image4 = new Image(sorce4);
            foodImg4.setImage(image4);
        }else {
            food4.setVisible(false);
        }
        ///////////////////////////////////////////--5
        id = (page*6)+4;
        if(id<size) {
            food5.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food5 = data.getFoodShowsList().get(idFood);
            foodName5.setText(food5.getName());
            String sorce5 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image5 = new Image(sorce5);
            foodImg5.setImage(image5);
        }else {
            food5.setVisible(false);
        }
        ///////////////////////////////////////////--6
        id = (page*6)+5;
        if(id<size) {
            food6.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food6 = data.getFoodShowsList().get(idFood);
            foodName6.setText(food6.getName());
            String sorce6 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image6 = new Image(sorce6);
            foodImg6.setImage(image6);
        }else {
            food6.setVisible(false);
        }
        if(page==0){
            prevButton.setVisible(false);
        }else {
            prevButton.setVisible(true);
        }
        if(page==((size-1)/6)){
            nextButton.setVisible(false);
        }else {
            nextButton.setVisible(true);
        }
    }

    @FXML
    void categoryPage(ActionEvent event) throws IOException {
        SceneCategory();
    }

    @FXML
    void foodRecipe1(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+0))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void foodRecipe2(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+1))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void foodRecipe3(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+2))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void foodRecipe4(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+3))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void foodRecipe5(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+4))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void foodRecipe6(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+5))-1;
        data.setIdFood(idFood);
        SceneShowFood();
    }

    @FXML
    void nextPage(ActionEvent event) {
        page++;
        updateData();
    }

    @FXML
    void prevPage(ActionEvent event) {
        page--;
        updateData();
    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        SceneSearch();
    }

//    @FXML
//    void closeButtonAction(MouseEvent event) {
//        Platform.exit();
//    }

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

    private void SceneShowFood() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent search = FXMLLoader.load(getClass().getResource("ShowFood.fxml"));
        Scene scene = new Scene(search);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void closeButtonAction(MouseEvent event) {
    }
}
