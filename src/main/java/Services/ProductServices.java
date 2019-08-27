package Services;


import model.Price;
import model.Product;
import org.bson.Document;
import db.Dao;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductServices {

    public static void createProduct(){

        Product newProduct = new Product(103, "camisa", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.insertDocument(newProduct);
    }
    public static void updateProduct(){

        Product newProduct = new Product(103, "camisa verde", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.updateDocument(newProduct);
    }}
