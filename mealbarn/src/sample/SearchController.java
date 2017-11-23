package sample;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooad.FoodShow;
import ooad.Component;
import org.controlsfx.control.textfield.TextFields;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SearchController {

	@FXML
    private Text accountName;

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXCheckBox isAlacarte;

    @FXML
    private JFXCheckBox isAppetizer;

    @FXML
    private JFXCheckBox isDessert;
	
	@FXML
    private JFXCheckBox isDrink;

    @FXML
    private JFXCheckBox isMainCourse;

    @FXML
    private JFXCheckBox isSoup;
	
	@FXML
    private JFXTextField ingredientType;
	
	@FXML
    private ListView<String> list;
    
    
    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
    }

	@FXML
    void categoryPage(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().categoryScene(stage);
    }

    @FXML
    void clearButtonAction(ActionEvent event){choosedList.clear();listCursor();}

	@FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

	@FXML
    void deleteIngredientsList (MouseEvent event) {
        if(event.getClickCount() > 1){
            choosedList.remove(list.getSelectionModel().getSelectedItem());
        }
        listCursor();
    }

	@FXML
    void ingredientsPressEnterAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addIngredientsBox();
        }
    }
    
    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        tempData.setAccount(null);
        tempData.setIdAccount(null);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().loginScene(stage);
    }

    @FXML
    void submitAction(ActionEvent event) throws IOException {
        if(!choosedList.isEmpty()) {
            foodData.clearPerfectFood();
            ArrayList<FoodShow> foodShowsList = foodData.getFoodShowsList();
            List<Component> componentList = foodData.getComponentList();
            ArrayList<String> select = new ArrayList<String>();
            if (isAlacarte.isSelected()) {
                select.addAll(foodData.getAlacateIDList());
            }
            if (isAppetizer.isSelected()) {
                select.addAll(foodData.getAppetizerIDList());
            }
            if (isDessert.isSelected()) {
                select.addAll(foodData.getDessertIDList());
            }
            if (isDrink.isSelected()) {
                select.addAll(foodData.getDrinkIDList());
            }
            if (isMainCourse.isSelected()) {
                select.addAll(foodData.getMainCourseIDList());
            }
            if (isSoup.isSelected()) {
                select.addAll(foodData.getSoupIDList());
            }

            if (!(isAlacarte.isSelected()) && !(isAppetizer.isSelected()) && !(isDessert.isSelected()) && !(isDrink.isSelected()) && !(isMainCourse.isSelected()) && !(isSoup.isSelected())) {
                select.addAll(foodData.getAlacateIDList());
                select.addAll(foodData.getAppetizerIDList());
                select.addAll(foodData.getDessertIDList());
                select.addAll(foodData.getDrinkIDList());
                select.addAll(foodData.getMainCourseIDList());
                select.addAll(foodData.getSoupIDList());
            }
            for (String choose : choosedList) {
                for (Component component : componentList) {
                    if (select.contains(component.getId().toString())) {
                        if (component.getComponent().compareTo(choose) == 0) {
                            int id = component.getId() - 1;
                            foodShowsList.get(id).addPerfect();
                        }
                    }
                }
            }
            foodData.setFoodShowsList(foodShowsList);
            tempData.setShowIDList();
            tempData.sortPerfect();
            choosedList.clear();
            isSoup.setSelected(false);
            isMainCourse.setSelected(false);
            isDrink.setSelected(false);
            isDessert.setSelected(false);
            isAppetizer.setSelected(false);
            isAlacarte.setSelected(false);
            tempData.setPage(0);
            Stage stage = (Stage) this.closeButton.getScene().getWindow();
            SceneData.getSceneData().resultSearchScene(stage);
        }
    }

	@FXML
    void initialize() {
        listCursor();
        allComponent = foodData.getAllComponent();
        accountName.setText(tempData.getAccount());
        TextFields.bindAutoCompletion(ingredientType,allComponent);
    }
	
	private ObservableList<String> choosedList = FXCollections.observableArrayList();
    private FoodData foodData = FoodData.getFoodData();
    private TempData tempData = TempData.getTempData();
    private ArrayList<String> allComponent;

	void addIngredientsBox(){
        String input = ingredientType.getText();
        if((input.length() != 0)&&!choosedList.contains(input)){
            if(allComponent.contains(input)) {
                list.setItems(choosedList);
                choosedList.add(input);
                ingredientType.clear();
            }
        }else {
            ingredientType.clear();
        }
        listCursor();
    }

    private void listCursor(){
        if(choosedList.isEmpty()){
            list.setCursor(Cursor.NONE);
        }else {
            list.setCursor(Cursor.HAND);
        }
    }


}
