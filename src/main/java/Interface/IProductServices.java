package Interface;

import model.Product;

import java.util.List;

public interface IProductServices {

    List<Product> getProducts();

    Product getProduct(int prodId);

    void createProduct(Product product);

    void updateProduct(Product product);

}
