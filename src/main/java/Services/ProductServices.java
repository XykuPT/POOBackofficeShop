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

    public static ProductServices getInstance(){ return new ProductServices();}

    @Override
    public List<Product> getProductsService() {
        List<Product> products = (List<Product>) Dao.getCollection("products");
        return products;
    }

    @Override
    public Product getProductService(int prodId) {

        Product product = (Product) Dao.getDocument(prodId, "products");
        return product;
    }

    /**
     * @param product
     */
    @Override
    public void createProductService(Product product){


        Dao.insertDocument(product, "products");
    }

    @Override
    public void updateProductService(Product product){

        Product newProduct = new Product(103, "camisa verde", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.updateProduct(newProduct);
    }}
