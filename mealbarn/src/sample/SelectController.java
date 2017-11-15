package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SelectController {

    @FXML
    private JFXButton IngredientsButton;

    @FXML
    private JFXButton CategoryButton;

    @FXML
    private ImageView CloseButton;

    @FXML
    void CategoryButtonAction(ActionEvent event) {
        Main.priStage.setScene(Main.Category);
    }

    @FXML
    void CloseButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void IngredientsButtonAction(ActionEvent event) {
        Main.priStage.setScene(Main.Search);
    }

}
