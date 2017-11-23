package sample;

import com.jfoenix.controls.JFXCheckBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class LoginController {
	
	@FXML
    private ImageView closeButton;

	@FXML
    private JFXCheckBox isRemember;

	@FXML
    private Pane loginPane;
	
	@FXML
    private PasswordField passR;

    @FXML
    private PasswordField passRagain;

	@FXML
    private TextField passType;

    @FXML
    private Pane registerPane;

    @FXML
    private TextField userR;
    
    @FXML
    private TextField userType;
    	
	@FXML
    void back (ActionEvent event) {
        userR.clear();
        passR.clear();
        passRagain.clear();
        loginPane.setVisible(true);
        registerPane.setVisible(false);
    }

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) throws IOException {
        String user = userType.getText();
        String pass = passType.getText();
        boolean canlogin = accountData.canLogin(user,pass);
        if(canlogin) {
            tempData.setRemember(isRemember.isSelected());
            Stage stage = (Stage) this.closeButton.getScene().getWindow();
            SceneData.getSceneData().searchScene(stage);
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
   
    @FXML
    void signupButtonAction(ActionEvent event) {
        userR.clear();
        passR.clear();
        passRagain.clear();
        loginPane.setVisible(false);
        registerPane.setVisible(true);
    }

    @FXML
    void initialize() {
        userType.clear();
        passType.clear();
        isRemember.setSelected(tempData.isRemember());
        if(tempData.isRemember()) {
            userType.setText(tempData.getAccountFill());
            passType.setText(tempData.getPassword());
        }
    }

	private TempData tempData = TempData.getTempData();
    private AccountData accountData = AccountData.getAccountData();
	
}
