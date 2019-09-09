package Controllers;

import Services.ProductServices;
import Services.SaleServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Product;
import model.Sale;

import java.io.IOException;


public class SalesController {

    private ObservableList<Sale> sales = FXCollections.observableArrayList();

    @FXML
    private AnchorPane salesPane;

    @FXML
    private TableView<Sale> salesTV;
    @FXML
    private TableColumn<Sale, Integer> saleId;
    @FXML
    private TableColumn<Sale,String> status;
    @FXML
    private TableColumn<Sale,String[]> product;
    @FXML
    private TableColumn<Sale,Integer> quantityTotal;
    @FXML
    private TableColumn<Sale,Integer> total;

    @FXML
    private void initialize() {
        saleId.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("saleId"));
        status.setCellValueFactory(new PropertyValueFactory<Sale, String>("status"));
        product.setCellValueFactory(new PropertyValueFactory<Sale, String[]>("product"));
        quantityTotal.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("quantityTotal"));
        total.setCellValueFactory(new PropertyValueFactory<Sale, Integer>("total"));

        sales.addAll(SaleServices.getInstance().getSalessService());

        salesTV.setItems(sales);
    }

    @FXML
    void newSale(ActionEvent event) throws IOException {
        AnchorPane newSale = FXMLLoader.load(getClass().getResource("/newSale.fxml"));
        salesPane.getChildren().setAll(newSale);
    }



}
