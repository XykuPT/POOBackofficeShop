package teste;


import Controllers.ProductsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Hello world!
 *
 */
//public class App extends Application

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        loader.setController(new ProductsController());
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello Xico!" );
        launch(args);

        System.out.println(ProductsController.getProducts());

        //ProductServices.createProduct();
        //ProductServices.updateProduct();
        //Dao.getCollection();
    }
}





