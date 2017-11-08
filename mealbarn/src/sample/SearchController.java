package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextArea IngredientsChoosedArea;

    @FXML
    private JFXButton addButton;

    ArrayList <String> choosed = new ArrayList<String>();
    String[] IngredientsList = {"Hai","Hello","ant"};

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void IngredientsTypeAction(KeyEvent event) {
        TextFields.bindAutoCompletion(IngredientType,IngredientsList);
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        addIngredientsBox();
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
                choosed.add(IngredientType.getText());
                String temp = "";
                for (String i : choosed) {
                    temp = temp + i + "\n";
                }
                IngredientsChoosedArea.setText(temp);
                IngredientType.clear();
            }
        }
    }


}
