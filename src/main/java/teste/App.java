package teste;

//import javafx.application.Application;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.fxml.FXMLLoader;
import db.Dao;

/**
 * Hello world!
 *
 */
//public class App extends Application

public class App
{
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("./Views/sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }

    public static void main( String[] args )
    {
        System.out.println( "Hello Xico estúpido!" );
        //launch(args);
        Dao.getCollection("products");
    }
}





