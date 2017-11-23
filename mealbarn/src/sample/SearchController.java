package sample;

<<<<<<< Updated upstream
import com.jfoenix.controls.JFXCheckBox;
=======
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
>>>>>>> Stashed changes
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
=======
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
>>>>>>> Stashed changes
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
=======
>>>>>>> Stashed changes
import ooad.FoodShow;
import ooad.Component;
import org.controlsfx.control.textfield.TextFields;


<<<<<<< Updated upstream
import java.io.IOException;
=======
import java.awt.*;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.List;


public class SearchController {

    @FXML
    private JFXTextField IngredientType;

    @FXML
    private ImageView closeButton;

    @FXML
<<<<<<< Updated upstream
=======
    private JFXButton addButton;

    @FXML
>>>>>>> Stashed changes
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
    private Text accountName;
//    private AnchorPane testPane;

    ObservableList<String> choosedList = FXCollections.observableArrayList();
    FoodData foodData = FoodData.getFoodData();
    TempData tempData = TempData.getTempData();
    ArrayList<String> allComponent;

    @FXML
    void initialize() {
        listCursor();
        allComponent = foodData.getAllComponent();
        accountName.setText(tempData.getAccount());
        TextFields.bindAutoCompletion(IngredientType,allComponent);
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
=======
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
>>>>>>> Stashed changes
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
    void deleteIngredientsList (MouseEvent event) {
        if(event.getClickCount() > 1){
<<<<<<< Updated upstream
            choosedList.remove(list.getSelectionModel().getSelectedItem());
        }
        listCursor();
=======
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
>>>>>>> Stashed changes
    }

    @FXML
    void IngredientsPressEnterAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addIngredientsBox();
        }
    }

    void addIngredientsBox(){
<<<<<<< Updated upstream
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
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().categoryScene(stage);
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        tempData.setAccount(null);
        tempData.setIdAccount(null);
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        SceneData.getSceneData().loginScene(stage);
    }

    private void listCursor(){
        if(choosedList.isEmpty()){
            list.setCursor(Cursor.NONE);
        }else {
            list.setCursor(Cursor.HAND);
        }
=======
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
//    @FXML
//    private void clickTest(){
//        testPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10;");
//
//    }

    @FXML
    void categorySelect(ActionEvent event) {
        Main.priStage.setScene(Main.Category);
>>>>>>> Stashed changes
    }


}
