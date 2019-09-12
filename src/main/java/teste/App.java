package teste;


import Controllers.ProductsController;
import Services.ProductServices;
import Services.SaleServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Arrays;

/**
 * Inicio da aplicação e main
 *
 */
//public class App extends Application

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        loader.setController(new ProductsController());
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 640, 500));
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        //System.out.println( "Hello Xico!" );
        launch(args);

        System.out.println(ProductsController.getProducts());
        System.out.println(SaleServices.getInstance().getSalesService());
        //Product newProduct = new Product(111, "camisa", "30€", 20,"shirts", Arrays.asList("azul", "branco"));
        //ProductsController.createProduct(newProduct);

//      Sale newSale = new Sale(01, "sold", Arrays.asList("101", "102"),60, 2);
//      SaleServices.getInstance().createSaleService(newSale);
//        Order newSale = new Order(01, "sold", new int[]{101, 102},60, 2,"teste","Teste");
//        SaleServices.getInstance().createSaleService(newSale);
        //ProductServices.updateProduct();
        //Dao.getCollection();
    }
}





