package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CategoryController {

    @FXML
    private ImageView CloseButton;

    @FXML
    void CloseButtonAction(MouseEvent event) {
        Platform.exit();
    }

}
