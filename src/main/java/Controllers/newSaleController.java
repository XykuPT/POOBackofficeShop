package Controllers;

import Services.ProductServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import model.Product;

import javax.swing.*;
import java.io.IOException;

public class newSaleController {
    @FXML
    private AnchorPane salesPane;

    @FXML
    private ToggleGroup saleType;

    @FXML
    private RadioButton sale;

    @FXML
    private RadioButton order;

    @FXML
    private ComboBox<Product> productsList = new ComboBox<>();

    @FXML
    private TextField quantity;

    @FXML
    private TextField TotalPrice;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField locationInput;

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        addressInput.setDisable(true);
        locationInput.setDisable(true);

        products.addAll(ProductServices.getInstance().getProductsService());

        productsList.setItems(products);

        productsList.setConverter(new StringConverter<Product>() {
            @Override
            public String toString(Product product) {
                return product.getName();
            }

            @Override
            public Product fromString(String string) {
                return null;
            }
        });


    }

    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
        salesPane.getChildren().setAll(sales);
    }

    @FXML
    void radioChange(ActionEvent event){
        if(sale.isSelected()){
            addressInput.setDisable(true);
            locationInput.setDisable(true);
        }else{
            addressInput.setDisable(false);
            locationInput.setDisable(false);
        }
    }

    @FXML
    void SubmitNewSale(ActionEvent event) {

    }
}
