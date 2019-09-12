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
import model.Order;
import model.Product;
import model.Sale;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * newSale view Controller - controlador da pagina de nova sale onde se preenche os campos para criar uma nova venda ou uma encomenda
 */
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

    /**
     * Método de inicialização do Controlador de nova venda. Faz load dos Produtos disponiveis da base de dados para apresetentar na comboBox para ser selecionado pelo User,
     * Associa a logica relacionado com os calculos e eventos de alteração de campos
     */
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


    /**
     * @param event button click
     * @throws IOException
     * Volta para a página anterior
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
        salesPane.getChildren().setAll(sales);
    }

    /**
     * @param event change radio button
     * Botão para o utilizador selecionar ser quer inserir uma sale ou uma order e desbloqueia ou bloqueia os campos adicionas da encomenda
     */
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

    /**
     * @param event button click event
     * @throws IOException
     * Faz submit da nova venda ou encomenda dependendo do que foi selecionado no radio button
     */
    @FXML
    void SubmitNewSale(ActionEvent event) throws IOException {
        Random rand = new Random();
        if(sale.isSelected()) {
            Sale newSale = new Sale("sale",rand.nextInt(1000), "New Sale", Arrays.asList(String.valueOf(chosenProduct.getProdId())), Integer.parseInt(TotalPrice.getText()), Integer.parseInt(quantity.getText()) );
            SaleServices.getInstance().createSaleService(newSale);
            AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
            salesPane.getChildren().setAll(sales);
        }else{
            Order newSale = new Order("order",rand.nextInt(1000), "New Sale", Arrays.asList(String.valueOf(chosenProduct.getProdId())), Integer.parseInt(TotalPrice.getText()), Integer.parseInt(quantity.getText()), addressInput.getText(), locationInput.getText() );
            SaleServices.getInstance().createSaleService(newSale);
            AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
            salesPane.getChildren().setAll(sales);
        }
    }
}
