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
import javafx.stage.Stage;
import ooad.FoodShow;
import ooad.Component;
import org.controlsfx.control.textfield.TextFields;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SearchController {

    @FXML
    private JFXTextField IngredientType;

    @FXML
    private ImageView closeButton;

    @FXML
    private ListView<String> list;

    @FXML
    private JFXCheckBox isAlacarte;

    @FXML
    private JFXCheckBox isDrink;

    @FXML
    private JFXCheckBox isAppetizer;

    @FXML
    private JFXCheckBox isDessert;

    @FXML
    private JFXCheckBox isMainCourse;

    @FXML
    private JFXCheckBox isSoup;
    @FXML
//    private AnchorPane testPane;

    ObservableList<String> choosedList = FXCollections.observableArrayList();
    FoodData foodData = FoodData.getFoodData();
    TempData tempData = TempData.getTempData();
    ArrayList<String> allComponent;

    @FXML
    void initialize() {
        listCursor();
        allComponent = foodData.getAllComponent();
        TextFields.bindAutoCompletion(IngredientType,allComponent);
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
    }

    @FXML
    void clearButtonAction(ActionEvent event){choosedList.clear();listCursor();}

    @FXML
    void submitAction(ActionEvent event) throws IOException {

//        testPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");

        foodData.clearPerfectFood();
        ArrayList<FoodShow> foodShowsList = foodData.getFoodShowsList();
        List<Component> componentList = foodData.getComponentList();
        ArrayList<String> select = new ArrayList<String>();
        if(isAlacarte.isSelected()){
            select.addAll(foodData.getAlacateIDList());
        }
        if(isAppetizer.isSelected()){
            select.addAll(foodData.getAppetizerIDList());
        }
        if(isDessert.isSelected()){
            select.addAll(foodData.getDessertIDList());
        }
        if(isDrink.isSelected()){
            select.addAll(foodData.getDrinkIDList());
        }
        if(isMainCourse.isSelected()){
            select.addAll(foodData.getMainCourseIDList());
        }
        if(isSoup.isSelected()){
            select.addAll(foodData.getSoupIDList());
        }

        if(!(isAlacarte.isSelected()) && !(isAppetizer.isSelected()) && !(isDessert.isSelected()) && !(isDrink.isSelected()) && !(isMainCourse.isSelected()) && !(isSoup.isSelected()) ){
            select.addAll(foodData.getAlacateIDList());
            select.addAll(foodData.getAppetizerIDList());
            select.addAll(foodData.getDessertIDList());
            select.addAll(foodData.getDrinkIDList());
            select.addAll(foodData.getMainCourseIDList());
            select.addAll(foodData.getSoupIDList());
        }
        for (String choose : choosedList){
            for (Component component : componentList){
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
        SceneResult();
    }

    @FXML
    void deleteIngredientsList (MouseEvent event) {
        if(event.getClickCount() > 1){
            choosedList.remove(list.getSelectionModel().getSelectedItem());
        }
        listCursor();
    }

    @FXML
    void IngredientsPressEnterAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addIngredientsBox();
        }
    }

    void addIngredientsBox(){
        String input = IngredientType.getText();
        if((input.length() != 0)&&!choosedList.contains(input)){
            if(allComponent.contains(input)) {
                list.setItems(choosedList);
                choosedList.add(input);
                IngredientType.clear();
            }
        }else {
            IngredientType.clear();
        }
        listCursor();
    }

    @FXML
    void categoryPage(ActionEvent event) throws IOException {
        SceneCategory();
    }

    private void SceneCategory() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent result = FXMLLoader.load(getClass().getResource("Category.fxml"));
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
    }

    private void SceneResult() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent result = FXMLLoader.load(getClass().getResource("ResultSearch.fxml"));
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
    }

    private void listCursor(){
        if(choosedList.isEmpty()){
            list.setCursor(Cursor.NONE);
        }else {
            list.setCursor(Cursor.HAND);
        }
    }
//    @FXML
//    private void clickTest(){
//        testPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
//
//    }


}
