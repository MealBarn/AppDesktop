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
import org.controlsfx.control.textfield.TextFields;


import java.util.ArrayList;


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
    Test test = Test.getInstance();
    String[] IngredientsList = {};
    String tempList;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void IngredientsTypeAction(KeyEvent event) {
        String subString = IngredientType.getText();
        ArrayList<String> matchIngredient = test.getMatchIngredient(subString);
        IngredientsList = matchIngredient.toArray(new String[matchIngredient.size()]);
        TextFields.bindAutoCompletion(IngredientType,IngredientsList);
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
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
            for(String i : IngredientsList){
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
