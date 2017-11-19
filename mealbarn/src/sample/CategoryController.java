package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CategoryController {

    @FXML
    private ImageView closeButton;

    @FXML
    void alacarteSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getAlacateIDList());
        SceneResult();
    }

    @FXML
    void appetizerSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getAppetizerIDList());
        SceneResult();
    }

    @FXML
    void closeButtonAction (MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void dessertSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getDessertIDList());
        SceneResult();
    }

    @FXML
    void drinkSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getDrinkIDList());
        SceneResult();
    }

    @FXML
    void maincourseSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getMainCourseIDList());
        SceneResult();
    }

    @FXML
    void soupSelect(ActionEvent event) throws IOException {
        data.setShowIDList(data.getSoupIDList());
        SceneResult();
    }

    @FXML
    void searchPage(ActionEvent event) throws IOException {
        SceneSearch();
    }

    Data data = Data.getData();

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(search);
        stage.setScene(scene);
        stage.show();
    }

    private void SceneResult() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent result = FXMLLoader.load(getClass().getResource("CategoryResult.fxml"));
        Scene scene = new Scene(result);
        stage.setScene(scene);
        stage.show();
=======
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

    @FXML
    void searchSelect(MouseEvent event) {
        Main.priStage.setScene(Main.Search);
>>>>>>> Stashed changes
    }

}
