package Interface;

import model.Product;

import java.util.List;

public interface IProductServices {

    List<Product> getProductsService();

    Product getProductService(int prodId);

    void createProductService(Product product);

    void updateProductService(Product product);

}
