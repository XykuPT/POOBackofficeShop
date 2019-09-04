package Controllers;


import Services.ProductServices;
import model.Product;

import java.util.List;

public class ProductsController {

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
