package sample;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javax.xml.soap.Text;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML
    private ImageView closeButton;

    @FXML
    private Text warningPass;

    @FXML
    private JFXTextField userType;

    @FXML
    private JFXPasswordField passType;

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
    }

}
