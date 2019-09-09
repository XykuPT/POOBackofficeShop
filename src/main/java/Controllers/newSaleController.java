package Controllers;

import Services.ProductServices;
import Services.SaleServices;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import model.Sale;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

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
    private TextField MaxQuantity;

    @FXML
    private TextField TotalPrice = new TextField();

    @FXML
    private TextField addressInput;

    @FXML
    private TextField locationInput;

    private ObservableList<Product> products = FXCollections.observableArrayList();
    private Product chosenProduct = new Product();

    @FXML
    private void initialize() {
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
                System.out.println("teste");
                return null;
            }
        });
        productsList.valueProperty().addListener(new ChangeListener<Product>() {
            @Override
            public void changed(ObservableValue<? extends Product> observable, Product oldValue, Product newValue) {
                chosenProduct = newValue;
                System.out.println(chosenProduct.getPrice().replaceFirst("€", ""));
                TotalPrice.setText(chosenProduct.getPrice().replaceFirst("€", ""));
                MaxQuantity.setText(String.valueOf(chosenProduct.getQty()));
            }
        });

        quantity.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*") || Integer.parseInt(newValue) > chosenProduct.getQty()) {
                    quantity.setText(newValue.replaceAll("[^\\d]", ""));
                    TotalPrice.setText(chosenProduct.getPrice().replaceFirst("€", ""));
                    System.out.println("textfield changed from " + oldValue + " to " + newValue);
                }else if(newValue.matches("\\d*")){
                    int newTotal = Integer.parseInt(quantity.getText()) * Integer.parseInt(chosenProduct.getPrice().replaceFirst("€", ""));
                    TotalPrice.setText(String.valueOf(newTotal));
                }else {
                    TotalPrice.setText(chosenProduct.getPrice().replaceFirst("€", ""));
                }
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
    void SubmitNewSale(ActionEvent event) throws IOException {
        Random rand = new Random();
        if(sale.isSelected()) {
            Sale newSale = new Sale(rand.nextInt(1000), "New Sale", Arrays.asList(String.valueOf(chosenProduct.getProdId())), Integer.parseInt(TotalPrice.getText()), Integer.parseInt(quantity.getText()) );
            SaleServices.getInstance().createSaleService(newSale);
            AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
            salesPane.getChildren().setAll(sales);
        }
    }
}
