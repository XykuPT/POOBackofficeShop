package Controllers;


import Services.ProductServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;

import java.util.List;

public class ProductsController {

    private ObservableList<Product> products = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> productsTV;
    @FXML
    private TableColumn<Product,Integer> prodId;
    @FXML
    private TableColumn<Product,String> name;
    @FXML
    private TableColumn<Product,String> price;
    @FXML
    private TableColumn<Product,Integer> qty;
    @FXML
    private TableColumn<Product,String> category;
    @FXML
    private TableColumn<Product,String[]> color;


    @FXML
    private void initialize() {
        prodId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("prodId"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
        qty.setCellValueFactory(new PropertyValueFactory<Product, Integer>("qty"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        color.setCellValueFactory(new PropertyValueFactory<Product, String[]>("color"));

        products.addAll(ProductServices.getInstance().getProductsService());


        productsTV.setItems(products);

    }



    public static List<Product> getProducts() {
        try {
            List<Product> output = ProductServices.getInstance().getProductsService();
            return output;
        }catch (Exception ex){
            throw ex;
        }
    }

    public static Product getProduct(int prodId){
        try {
            Product output = ProductServices.getInstance().getProductService(prodId);
            return output;

        }catch (Exception ex){
            throw ex;
        }
    }

    public static void createProduct(Product product){
        try{
            ProductServices.getInstance().createProductService(product);

        }catch (Exception ex){
            throw ex;
        }
    }

    public static void updateProduct(Product product){
        try{
            ProductServices.getInstance().updateProductService(product);
        }catch (Exception ex){
            throw ex;
        }
    }

}
