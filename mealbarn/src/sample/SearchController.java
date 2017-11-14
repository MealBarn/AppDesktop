package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import ooad.FoodShow;
import ooad.Component;
import org.controlsfx.control.textfield.TextFields;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SearchController {

    @FXML
    private JFXTextField IngredientType;

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXButton addButton;

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

    ObservableList<String> choosedList = FXCollections.observableArrayList();
    Data data = Data.getData();
    String[] componentList = {};
    String tempList;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void IngredientsTypeAction(KeyEvent event) {
        String inputStr = IngredientType.getText();
        ArrayList<String> matchComponent = data.getMatchComponent(inputStr);
        for (String component : choosedList){
            if (matchComponent.contains(component)){
                matchComponent.remove(component);
            }
        }
        componentList = matchComponent.toArray(new String[matchComponent.size()]);
        TextFields.bindAutoCompletion(IngredientType,componentList);
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
    }

    @FXML
    void submitAction(ActionEvent event) {
        System.out.println("=================================================================");
        data.clearPerfectFood();
        ArrayList<FoodShow> foodShowsList = data.getFoodShowsList();
        List<Component> componentList = data.getComponentList();
        ArrayList<String> select = new ArrayList<String>();
        if(isAlacarte.isSelected()){
            select.addAll(data.getAlacateIDList());
        }
        if(isAppetizer.isSelected()){
            select.addAll(data.getAppetizerIDList());
        }
        if(isDessert.isSelected()){
            select.addAll(data.getDessertIDList());
        }
        if(isDrink.isSelected()){
            select.addAll(data.getDrinkIDList());
        }
        if(isMainCourse.isSelected()){
            select.addAll(data.getMainCourseIDList());
        }
        if(isSoup.isSelected()){
            select.addAll(data.getSoupIDList());
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
        data.setFoodShowsList(foodShowsList);
        data.setShowIDList();
        data.sortPerfect();
    }

    @FXML
    void deleteIngredientsList (MouseEvent event) {
        if(event.getClickCount() > 1){
            int index = 0;
            tempList = list.getSelectionModel().getSelectedItem();
            for(String name : choosedList){
                if (name.equals(tempList)) {
                    choosedList.remove(index);
                    break;
                }
                index++;
            }
        }
    }

    @FXML
    void IngredientsPressEnterAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addIngredientsBox();
        }
    }

    void addIngredientsBox(){
        if((IngredientType.getText().length() != 0)&&!choosedList.contains(IngredientType.getText())){
            boolean checkMatch = false;
            for(String i : componentList){
                if(i.equals(IngredientType.getText())){
                    checkMatch = true;
                }
            }
            if(checkMatch == true) {
                list.setItems(choosedList);
                choosedList.add(IngredientType.getText());
                IngredientType.clear();
            }
        }
    }

    @FXML
    void categorySelect(ActionEvent event) {
        Main.priStage.setScene(Main.Category);
    }


}
