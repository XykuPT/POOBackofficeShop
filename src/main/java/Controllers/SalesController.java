package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class SalesController {
    @FXML
    private AnchorPane salesPane;

    @FXML
    void newSale(ActionEvent event) throws IOException {
        AnchorPane newSale = FXMLLoader.load(getClass().getResource("/newSale.fxml"));
        salesPane.getChildren().setAll(newSale);
    }



}
