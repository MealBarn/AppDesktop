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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ooad.Account;

import java.io.IOException;

public class LoginController {

    @FXML
    private Pane registerPane;

    @FXML
    private TextField userR;

    @FXML
    private TextField passR;

    @FXML
    private TextField passRagain;

    @FXML
    private Pane loginPane;

    @FXML
    private ImageView closeButton;

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
        }
    }

    @FXML
    void signUp(ActionEvent event) {
        String user = userR.getText();
        String pass = passR.getText();
        String passA = passRagain.getText();
        if(AccountData.getAccountData().isDuplicateUser(user)){
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
                registerPane.setVisible(false);
                loginPane.setVisible(true);
            }
        }
    }

    @FXML
    void signupButtonAction(ActionEvent event) {
        loginPane.setVisible(false);
        registerPane.setVisible(true);
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
