package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
        if(IngredientType.getText().length() != 0){
            choosed.add(IngredientType.getText());
            String temp = "";
            for (String i : choosed){
                temp = temp + i +"\n";
            }
            IngredientsChoosedArea.setText(temp);
            IngredientType.clear();
        }
    }

}
