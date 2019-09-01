package Controllers;


import Services.ProductServices;
import model.Product;

import java.util.List;

public class ProductsController {

    List<Product> output = ProductServices.getInstance().getProducts();

}
