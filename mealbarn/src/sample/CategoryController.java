package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CategoryController {
    Data data = Data.getData();

    @FXML
    private ImageView CloseButton;

    @FXML
    void CloseButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void alacarteSelect(ActionEvent event) {
        data.setShowIDList(data.getAlacateIDList());
        printId();
    }

    @FXML
    void appetizerSelect(ActionEvent event) {
        data.setShowIDList(data.getAppetizerIDList());
        printId();
    }

    @FXML
    void dessertSelect(ActionEvent event) {
        data.setShowIDList(data.getDessertIDList());
        printId();
    }

    @FXML
    void drinkSelect(ActionEvent event) {
        data.setShowIDList(data.getDrinkIDList());
        printId();
    }

    @FXML
    void maincourseSelect(ActionEvent event) {
        data.setShowIDList(data.getMainCourseIDList());
        printId();
    }

    @FXML
    void soupSelect(ActionEvent event) {
        data.setShowIDList(data.getSoupIDList());
        printId();
    }

    void printId(){
        for (String s : data.getShowIDList()){
            System.out.println(s);
        }
    }

}
