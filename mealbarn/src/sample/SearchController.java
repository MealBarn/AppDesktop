package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SearchController {

    @FXML
    private ImageView closeButton;

    @FXML
    void closeButtonAction(MouseEvent event) {
        Platform.exit();
    }

}
