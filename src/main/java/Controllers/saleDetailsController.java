package Controllers;

import Services.ProductServices;
import Services.SaleServices;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Product;
import model.Sale;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Controller para a pagina de detalhes de uma unica venda, recebe o ID da venda
 */
public class saleDetailsController {
    private int saleId;
    private Sale sale;
    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    private AnchorPane salesPane;

    @FXML
    private TextField total;

    @FXML
    private TextField saleID;

    @FXML
    private TextField quantity;

    @FXML
    private TextField status;
    @FXML
    private TableView<Product> productsTV;
    @FXML
    private TableColumn<Product,Integer> prodId;
    @FXML
    private TableColumn<Product,String> name;
    @FXML
    private TableColumn<Product,String> price;

    /**
     * Método inicialização da pagina recebe o ID da venda da pagina anterior e vai a base de dados buscar todos os detalhes da venda e apresenta nos textfield's
     * e depois vai buscar todos os produtos da venda para apresentar numa listagem
     */
    @FXML
    private void initialize() {

        System.out.println(saleId);

        sale = SaleServices.getInstance().getSaleService(saleId);
        total.setText(String.valueOf(sale.getTotal()));
        saleID.setText(String.valueOf(sale.getSaleId()));
        quantity.setText(String.valueOf(sale.getQuantityTotal()));
        status.setText(sale.getStatus());
        for (String productID: sale.getProduct())
        {
            productList.add(ProductServices.getInstance().getProductService(parseInt(productID)));
        }
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("prodId"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        productsTV.setItems(productList);
    }

    /**
     * Evento de Click no botão para voltar a pagina anterior
     * @param event
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        AnchorPane sales = FXMLLoader.load(getClass().getResource("/sales.fxml"));
        salesPane.getChildren().setAll(sales);
    }


    /**
     * Métedo que recebe o sale ID da pagina anterior
     * @param id
     */
    public void setData(int id){

        this.saleId = id;
    }
}
