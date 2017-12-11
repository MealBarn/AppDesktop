package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;
import ooad.ImageSize;
import java.io.IOException;
import java.util.List;

public class ShowFoodController {
	
	@FXML
    private Text accountName;

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXButton dirButton;
	
	@FXML
    private ImageView foodImg;

    @FXML
    private Text foodName;

    @FXML
    private ImageView imgDetail;

    @FXML
    private JFXButton ingButton;
	
    @FXML
    private Pane nextPane;

    @FXML
    private Pane prevPane;
	
	@FXML
    void backPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().backScene(stage,tempData.getMode());
    }

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
    void likePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().resultLikeScene(stage);
    }

	@FXML
    void logoutAction(ActionEvent event) throws IOException {
        tempData.setAccount(null);
        tempData.setIdAccount(null);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().loginScene(stage);
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
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().searchScene(stage);
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
        accountName.setText(tempData.getAccount());
        updateButton();
        ingButton.setDisable(true);
    }

    private FoodData foodData = FoodData.getFoodData();
    private TempData tempData = TempData.getTempData();
    private List<ImageSize> imageSizeList = foodData.getImageSizeList();
    private int idFood = tempData.getIdFood();
    private int sizeIng = imageSizeList.get(idFood).getImgSize();
    private int sizeDir = imageSizeList.get(idFood).getDirSize();
    private int pageSize;
    private int page;
    private int mode;
    
    void setImg(){
        String sorceD = String.format("./img/foodRecipe/%d-%d-%d.png",idFood+1,mode,page);
        Image imageD = new Image(sorceD);
        imgDetail.setImage(imageD);
    }

	void updateButton(){
        if(page==1){
            prevPane.setVisible(false);
        }else {
            prevPane.setVisible(true);
        }
        if(page==pageSize){
            nextPane.setVisible(false);
        }else {
            nextPane.setVisible(true);
        }
    }

}
