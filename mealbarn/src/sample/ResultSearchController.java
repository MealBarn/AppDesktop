package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;
import ooad.Like;

public class ResultSearchController {

    @FXML
    private Pane food1;

    @FXML
    private Pane food2;

    @FXML
    private Pane food3;

    @FXML
    private Pane food4;

    @FXML
    private Pane food5;

    @FXML
    private Pane food6;

    @FXML
    private ImageView foodImg1;

    @FXML
    private ImageView foodImg2;

    @FXML
    private ImageView foodImg3;

    @FXML
    private ImageView foodImg4;

    @FXML
    private ImageView foodImg5;

    @FXML
    private ImageView foodImg6;

    @FXML
    private Text foodName1;

    @FXML
    private Text foodName2;

    @FXML
    private Text foodName3;

    @FXML
    private Text foodName4;

    @FXML
    private Text foodName5;

    @FXML
    private Text foodName6;

    @FXML
    private JFXProgressBar foodScale1;

    @FXML
    private JFXProgressBar foodScale2;

    @FXML
    private JFXProgressBar foodScale3;

    @FXML
    private JFXProgressBar foodScale4;

    @FXML
    private JFXProgressBar foodScale5;

    @FXML
    private JFXProgressBar foodScale6;

    @FXML
    private Text foodPerfect1;

    @FXML
    private Text foodPerfect2;

    @FXML
    private Text foodPerfect3;

    @FXML
    private Text foodPerfect4;

    @FXML
    private Text foodPerfect5;

    @FXML
    private Text foodPerfect6;

    @FXML
    private ImageView likeImg1;

    @FXML
    private ImageView likeImg2;

    @FXML
    private ImageView likeImg3;

    @FXML
    private ImageView likeImg4;

    @FXML
    private ImageView likeImg5;

    @FXML
    private ImageView likeImg6;

    @FXML
    private Text likeN1;

    @FXML
    private Text likeN2;

    @FXML
    private Text likeN3;

    @FXML
    private Text likeN4;

    @FXML
    private Text likeN5;

    @FXML
    private Text likeN6;


    @FXML
    private ImageView closeButton;

    @FXML
    private ImageView prevImg;

    @FXML
    private ImageView nextImg;

    @FXML
    private Text pageId;

    @FXML
    private Text recipeCount;

    @FXML
    private Text accountName;

    @FXML
    void categoryPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().categoryScene(stage);
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void foodRecipe1(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+0))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void foodRecipe2(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+1))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void foodRecipe3(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+2))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void foodRecipe4(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+3))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void foodRecipe5(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+4))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void foodRecipe6(ActionEvent event) throws IOException {
        int idFood = Integer.parseInt(idShow.get((page*6)+5))-1;
        tempData.setIdFood(idFood);
        tempData.setMode("Search");
        tempData.setPage(page);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().showFoodScene(stage);
    }

    @FXML
    void like_unlike1(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+0))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void like_unlike2(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+1))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void like_unlike3(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+2))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void like_unlike4(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+3))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void like_unlike5(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+4))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void like_unlike6(MouseEvent event) {
        int idFood = Integer.parseInt(idShow.get((page*6)+5))-1;
        LikeData.getLikeData().activeLike(idFood);
        updateLike();
    }

    @FXML
    void nextPage(MouseEvent event) {
        page++;
        updateData();
        updateLike();
    }

    @FXML
    void prevPage(MouseEvent event) {
        page--;
        updateData();
        updateLike();
    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().searchScene(stage);
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        tempData.setAccount(null);
        tempData.setIdAccount(null);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().loginScene(stage);
    }

    @FXML
    void initialize() {
        idShow = tempData.getShowIDList();
        page = tempData.getPage();
        size = tempData.getShowIDList().size();
        recipeCount.setText(String.format("Total %d Recipes",size));
        accountName.setText(tempData.getAccount());
        updateData();
        updateLike();
    }

    int page;
    int size;
    ArrayList<String> idShow;
    FoodData foodData = FoodData.getFoodData();
    TempData tempData = TempData.getTempData();

    void updateLike(){
        ArrayList<Like> likeList = LikeData.getLikeData().getLikeList();
        String sorce = "./img/like_fill.png";
        Image fill = new Image(sorce);
        sorce = "./img/like_unfill.png";
        Image unfill = new Image(sorce);
        Like like;
        int idFood;
        int id;
        //////////////////////////--1
        id = (page*6)+0;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN1.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg1.setImage(unfill);
        }else {
            likeImg1.setImage(fill);
        }
        //////////////////////////--2
        id = (page*6)+1;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN2.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg2.setImage(unfill);
        }else {
            likeImg2.setImage(fill);
        }
        //////////////////////////--3
        id = (page*6)+2;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN3.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg3.setImage(unfill);
        }else {
            likeImg3.setImage(fill);
        }
        //////////////////////////--4
        id = (page*6)+3;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN4.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg4.setImage(unfill);
        }else {
            likeImg4.setImage(fill);
        }
        //////////////////////////--5
        id = (page*6)+4;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN5.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg5.setImage(unfill);
        }else {
            likeImg5.setImage(fill);
        }
        //////////////////////////--6
        id = (page*6)+5;
        if(id>=size) return;
        idFood = Integer.parseInt(idShow.get(id))-1;
        like = likeList.get(idFood);
        likeN1.setText(like.getSumValue()+"");
        if(like.getValue()==null){
            likeImg6.setImage(unfill);
        }else {
            likeImg6.setImage(fill);
        }
    }

    void updateData(){
        int id;
        int idFood;
        String pageNum = String.format("%d",page+1);
        pageId.setText(pageNum);
        ///////////////////////////////////////////--1
        id = (page*6)+0;
        if(id<size) {
            food1.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food1 = foodData.getFoodShowsList().get(idFood);
            foodName1.setText(food1.getName());
            foodPerfect1.setText(food1.getPerfect() + "%");
            String sorce1 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image1 = new Image(sorce1);
            foodImg1.setImage(image1);
            foodScale1.setProgress(food1.getPerfect() / 100);
        }else {
            food1.setVisible(false);
        }
        ///////////////////////////////////////////--2
        id = (page*6)+1;
        if(id<size) {
            food2.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food2 = foodData.getFoodShowsList().get(idFood);
            foodName2.setText(food2.getName());
            foodPerfect2.setText(food2.getPerfect() + "%");
            String sorce2 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image2 = new Image(sorce2);
            foodImg2.setImage(image2);
            foodScale2.setProgress(food2.getPerfect() / 100);
        }else {
            food2.setVisible(false);
        }
        ///////////////////////////////////////////--3
        id = (page*6)+2;
        if(id<size) {
            food3.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food3 = foodData.getFoodShowsList().get(idFood);
            foodName3.setText(food3.getName());
            foodPerfect3.setText(food3.getPerfect() + "%");
            String sorce3 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image3 = new Image(sorce3);
            foodImg3.setImage(image3);
            foodScale3.setProgress(food3.getPerfect() / 100);
        }else {
            food3.setVisible(false);
        }
        ///////////////////////////////////////////--4
        id = (page*6)+3;
        if(id<size) {
            food4.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food4 = foodData.getFoodShowsList().get(idFood);
            foodName4.setText(food4.getName());
            foodPerfect4.setText(food4.getPerfect() + "%");
            String sorce4 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image4 = new Image(sorce4);
            foodImg4.setImage(image4);
            foodScale4.setProgress(food4.getPerfect() / 100);
        }else {
            food4.setVisible(false);
        }
        ///////////////////////////////////////////--5
        id = (page*6)+4;
        if(id<size) {
            food5.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food5 = foodData.getFoodShowsList().get(idFood);
            foodName5.setText(food5.getName());
            foodPerfect5.setText(food5.getPerfect() + "%");
            String sorce5 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image5 = new Image(sorce5);
            foodImg5.setImage(image5);
            foodScale5.setProgress(food5.getPerfect() / 100);
        }else {
            food5.setVisible(false);
        }
        ///////////////////////////////////////////--6
        id = (page*6)+5;
        if(id<size) {
            food6.setVisible(true);
            idFood = Integer.parseInt(idShow.get(id))-1;
            FoodShow food6 = foodData.getFoodShowsList().get(idFood);
            foodName6.setText(food6.getName());
            foodPerfect6.setText(food6.getPerfect() + "%");
            String sorce6 = "./img/imgFood/"+idShow.get(id)+".png";
            Image image6 = new Image(sorce6);
            foodImg6.setImage(image6);
            foodScale6.setProgress(food6.getPerfect() / 100);
        }else {
            food6.setVisible(false);
        }
        if(page==0){
            prevImg.setVisible(false);
        }else {
            prevImg.setVisible(true);
        }
        if(page>=((size-1)/6)){
            nextImg.setVisible(false);
        }else {
            nextImg.setVisible(true);
        }
    }

}
