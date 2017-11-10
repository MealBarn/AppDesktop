package sample;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController {


    @FXML
    private JFXButton loginButton;

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

    @FXML
    void closeCursor(MouseEvent event) {
        closeButton.setCursor(Cursor.HAND);
    }

    @FXML
    void loginCursor(MouseEvent event) {
        loginButton.setCursor(Cursor.HAND);
    }



}
