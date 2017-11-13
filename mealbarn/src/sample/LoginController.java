package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        TestAcc ob = TestAcc.getInstance();
        ArrayList<String> acc = ob.getAccount();
        for (String user : acc){
            System.out.println(user);
        }
        String user = userType.getText();
        String pass = passType.getText();
        String uTest = String.format("%s %s",user,pass);
        System.out.println("This User :" + uTest);
        System.out.println(acc.contains(uTest));
        boolean canLog = acc.contains(uTest);
        if(canLog) {
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



}
