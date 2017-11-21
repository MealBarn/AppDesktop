package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private ImageView closeButton;

//    @FXML
//    private Text warningPass;

    @FXML
    private TextField userType;

    @FXML
    private TextField passType;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        String user = userType.getText();
        String pass = passType.getText();
        boolean canlogin = AccountData.getAccountData().canLogin(user,pass);
        if(canlogin) {
            SceneSearch();
        }
        else {
            passType.clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login error");
            alert.setHeaderText("The user name or password is incorrect");
            alert.setContentText("Check you user name ,then type your password again.");
            alert.showAndWait();
//            warningPass.setVisible(true);
        }
    }

    @FXML
    void initialize() {
        userType.setText("Korn");
        passType.setText("58010316");
    }

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent login = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(login);
        stage.setScene(scene);
        stage.show();
    }
//aaaa
}
