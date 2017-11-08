package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Button loginButton;

    @FXML
    private ImageView closeButton;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
            Main.priStage.setScene(Main.Select);
    }

}
