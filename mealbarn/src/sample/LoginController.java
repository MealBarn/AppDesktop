package sample;

<<<<<<< Updated upstream
=======
import com.jfoenix.controls.JFXButton;
>>>>>>> Stashed changes
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
=======
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

>>>>>>> Stashed changes
import java.util.ArrayList;

public class LoginController {

<<<<<<< Updated upstream
    @FXML
    private ImageView closeButton;

    @FXML
    private Text warningPass;
=======

    @FXML
    private JFXButton loginButton;

    @FXML
    private ImageView closeButton;
>>>>>>> Stashed changes

    @FXML
    private JFXTextField userType;

    @FXML
    private JFXPasswordField passType;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
<<<<<<< Updated upstream
    void loginButtonAction(ActionEvent event) throws IOException {
=======
    void loginButtonAction(ActionEvent event) {
>>>>>>> Stashed changes
        Data data = Data.getData();
        ArrayList<String> acc = data.getAccountStr();
        String user = userType.getText();
        String pass = passType.getText();
        String uTest = String.format("%s %s",user,pass);
        boolean canLog = acc.contains(uTest);
        if(canLog) {
<<<<<<< Updated upstream
            SceneSearch();
        }
        else {
            passType.clear();
            warningPass.setVisible(true);
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
=======
            Main.priStage.setScene(Main.Select);
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

    @FXML
    void autoInput(MouseEvent event){
        userType.setText("Suzy");
        passType.setText("58011348");
>>>>>>> Stashed changes
    }

}
