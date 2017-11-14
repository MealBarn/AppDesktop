package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import ooad.Food;
import ooad.FoodShow;

public class ResultSearchController {

    @FXML
    private Pane food1;

    @FXML
    private ImageView foodImg1;

    @FXML
    private Text foodName1;

    @FXML
    private JFXProgressBar foodScale1;

    @FXML
    private Text foodPerfect1;

    @FXML
    private Pane food2;

    @FXML
    private ImageView foodImg2;

    @FXML
    private Text foodName2;

    @FXML
    private JFXProgressBar foodScale2;

    @FXML
    private Text foodPerfect2;

    @FXML
    private Pane food3;

    @FXML
    private ImageView foodImg3;

    @FXML
    private Text foodName3;

    @FXML
    private JFXProgressBar foodScale3;

    @FXML
    private Text foodPerfect3;

    @FXML
    private Pane food4;

    @FXML
    private ImageView foodImg4;

    @FXML
    private Text foodName4;

    @FXML
    private JFXProgressBar foodScale4;

    @FXML
    private Text foodPerfect4;

    @FXML
    private Pane food5;

    @FXML
    private ImageView foodImg5;

    @FXML
    private Text foodName5;

    @FXML
    private JFXProgressBar foodScale5;

    @FXML
    private Text foodPerfect5;

    @FXML
    private Pane food6;

    @FXML
    private ImageView foodImg6;

    @FXML
    private Text foodName6;

    @FXML
    private JFXProgressBar foodScale6;

    @FXML
    private Text foodPerfect6;

    @FXML
    private JFXButton nextButton;

    @FXML
    private JFXButton prevButton;


    @FXML
    private ImageView closeButton;

    Data data = Data.getData();

    @FXML
    void initialize() {

    }

    void openData(){
        ArrayList<String> idShow = data.getShowIDList();
        int page = 0;
        int size = data.getShowIDList().size();
        int id;
        int idFood;
        ///////////////////////////////////////////--1
        id = (page*6)+0;
        if(id<size) {
            food1.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food1 = data.getFoodShowsList().get(idFood);
            foodName1.setText(food1.getName());
            foodPerfect1.setText(food1.getPerfect() + "%");
            String sorce1 = "./img/Alacarte/1.png";
            Image image1 = new Image(sorce1);
            foodImg1.setImage(image1);
            foodScale1.setProgress(food1.getPerfect() / 100);
            System.out.println(food1.toString());
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
            foodPerfect2.setText(food2.getPerfect() + "%");
            String sorce2 = "./img/Alacarte/2.png";
            Image image2 = new Image(sorce2);
            foodImg2.setImage(image2);
            foodScale2.setProgress(food2.getPerfect() / 100);
            System.out.println(food2.toString());
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
            foodPerfect3.setText(food3.getPerfect() + "%");
            String sorce3 = "./img/Alacarte/3.png";
            Image image3 = new Image(sorce3);
            foodImg3.setImage(image3);
            foodScale3.setProgress(food3.getPerfect() / 100);
            System.out.println(food3.toString());
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
            foodPerfect4.setText(food4.getPerfect() + "%");
            String sorce4 = "./img/Alacarte/4.png";
            Image image4 = new Image(sorce4);
            foodImg4.setImage(image4);
            foodScale4.setProgress(food4.getPerfect() / 100);
            System.out.println(food4.toString());
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
            foodPerfect5.setText(food5.getPerfect() + "%");
            String sorce5 = "./img/Alacarte/5.png";
            Image image5 = new Image(sorce5);
            foodImg5.setImage(image5);
            foodScale5.setProgress(food5.getPerfect() / 100);
            System.out.println(food5.toString());
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
            foodPerfect6.setText(food6.getPerfect() + "%");
            String sorce6 = "./img/Alacarte/6.png";
            Image image6 = new Image(sorce6);
            foodImg6.setImage(image6);
            foodScale6.setProgress(food6.getPerfect() / 100);
            System.out.println(food6.toString());
        }else {
            food6.setVisible(false);
        }
    }

    @FXML
    void categoryPage(ActionEvent event) {
        Main.priStage.setScene(Main.Category);
    }

    @FXML
    void closeButtonAction(MouseEvent event) {

    }

    @FXML
    void foodRecipe1(ActionEvent event) {

    }

    @FXML
    void foodRecipe2(ActionEvent event) {

    }

    @FXML
    void foodRecipe3(ActionEvent event) {

    }

    @FXML
    void foodRecipe4(ActionEvent event) {

    }

    @FXML
    void foodRecipe5(ActionEvent event) {

    }

    @FXML
    void foodRecipe6(ActionEvent event) {

    }

    @FXML
    void nextPage(ActionEvent event) {

    }

    @FXML
    void prevPage(ActionEvent event) {

    }

    @FXML
    void searchPage(ActionEvent event) {
        Main.priStage.setScene(Main.Search);
    }

}
