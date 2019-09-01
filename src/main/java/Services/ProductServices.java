package Services;


import Interface.IProductServices;
import model.Price;
import model.Product;
import org.bson.Document;
import db.Dao;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ProductServices implements IProductServices {

    private ProductServices instance = new ProductServices();
    public ProductServices getInstance(){ return this.instance;}

    @Override
    public static List<Product> getProducts() {
        List<Product> products = (List<Product>) Dao.getCollection("products");
        return products;
    }

    @Override
    public Product getProduct(int prodId) {
        return null;
    }

    @Override
    public void createProduct(Product product){

        Product newProduct = new Product(103, "camisa", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.insertDocument(newProduct);
    }

    @Override
    public void updateProduct(Product product){

        Product newProduct = new Product(103, "camisa verde", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.updateDocument(newProduct);
    }}
