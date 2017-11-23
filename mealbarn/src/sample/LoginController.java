package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ooad.Account;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

<<<<<<< Updated upstream
    @FXML
    private Pane registerPane;

    @FXML
    private TextField userR;

    @FXML
    private PasswordField passR;

    @FXML
    private PasswordField passRagain;

    @FXML
    private Pane loginPane;

    @FXML
    private ImageView closeButton;

    @FXML
    private Text warningPass;

    @FXML
    private JFXTextField userType;

    @FXML
    private JFXCheckBox isRemember;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
<<<<<<< Updated upstream
    void loginButtonAction(ActionEvent event) throws IOException {
        Data data = Data.getData();
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
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        String user = userR.getText();
        String pass = passR.getText();
        String passA = passRagain.getText();
        if(accountData.isDuplicateUser(user)||user.length()<3){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Register error");
            alert.setHeaderText("The user name is Duplicate");
            alert.setContentText("Please change your user name.");
            alert.showAndWait();
        }else {
            if(pass.compareTo(passA)!=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Register error");
                alert.setHeaderText("Passwords do not match");
                alert.setContentText("Please type your password again.");
                alert.showAndWait();
                passR.clear();
                passRagain.clear();
            }else {
                if(pass.length()>=4) {
                    userType.clear();
                    passType.clear();
                    accountData.addAccount(user, pass);
                    registerPane.setVisible(false);
                    loginPane.setVisible(true);
                }else {
                    passR.clear();
                    passRagain.clear();
                }
            }
        }
    }

    private void SceneSearch() throws IOException {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        Parent login = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(login);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void closeCursor(MouseEvent event) {
        closeButton.setCursor(Cursor.HAND);
    }

}
