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

    Data data = Data.getData();

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        ArrayList<String> acc = data.getAccountStr();
        String user = userType.getText();
        String pass = passType.getText();
        String uTest = String.format("%s %s",user,pass);
        boolean canLog = acc.contains(uTest);
        if(canLog) {
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
