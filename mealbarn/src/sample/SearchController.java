package sample;

import com.jfoenix.controls.JFXButton;
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
        componentList = matchComponent.toArray(new String[matchComponent.size()]);
        TextFields.bindAutoCompletion(IngredientType,componentList);
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
    }

    @FXML
    void submitAction(ActionEvent event) {
        System.out.println("submit");
        ArrayList<FoodShow> foodShowsList = data.getFoodShowsList();
        List<Component> componentList = data.getComponentList();
        for (String choose : choosedList){
            for (Component component : componentList){
                if(component.getComponent().compareTo(choose)==0){
                    int id = component.getId()-1;
                    FoodShow food = foodShowsList.get(id);
                    food.addPerfect();
                }
            }
        }
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
        if(IngredientType.getText().length() != 0){
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


}
