package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private JFXButton loginButton;

    @FXML
    private ImageView closeButton;

    @FXML
    private JFXTextField userType;

    @FXML
    private JFXPasswordField passType;

    @FXML
    void initialize() {
        userType.setText("Korn");
        passType.setText("58010316");
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        Data data = Data.getData();
        ArrayList<String> acc = data.getAccountStr();
        String user = userType.getText();
        String pass = passType.getText();
        String uTest = String.format("%s %s",user,pass);
        boolean canLog = acc.contains(uTest);
        if(canLog) {
            //Main.priStage.setScene(Main.Search);
            SceneSearch();
        }
        else {
            passType.clear();
        }
    }
    @FXML
    void closeCursor(MouseEvent event) {
        closeButton.setCursor(Cursor.HAND);
    }

    @FXML
    void loginCursor(MouseEvent event) {
        loginButton.setCursor(Cursor.HAND);
    }

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        Parent login = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(login);
        stage.setScene(scene);
        stage.show();
    }

}
