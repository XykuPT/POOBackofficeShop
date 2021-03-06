package Services;


import Interface.IProductServices;
import model.Price;
import model.Product;
import org.bson.Document;
import db.Dao;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Classe de Serviços de produtos que liga os controladores das views à base de dados
 */
public class ProductServices implements IProductServices {

    public static ProductServices getInstance(){ return new ProductServices();}

    /**
     * Serviço que vai a base de dados buscar lstagem de produtos
     * @return Serviço que retorna da base de dados a lIstagem de produtos
     */
    @Override
    public List<Product> getProductsService() {
        List<Product> products = (List<Product>) Dao.getCollection("products");
        return products;
    }

    /**
     * Serviço que vai a base de dados buscar um produto com base no Id inserido
     * @param prodId Id de Produto
     * @return Serviço retorna um produto com base no Id inserido
     */
    @Override
    public Product getProductService(int prodId) {

        Product product = (Product) Dao.getDocument(prodId, "products");
        return product;
    }

    /**
     * Serviço de Criar um novo produto
     * @param product Produto a ser inserido na base de dados
     */
    @Override
    public void createProductService(Product product){


        Dao.insertDocument(product, "products");
    }

    /**
     * Serviço que vai atualizar um produto
     * @param product Produto a ser atualizado na base de dados
     */
    @Override
    public void updateProductService(Product product){

        //Product newProduct = new Product(103, "camisa verde", "30€", 5,"shirts", Arrays.asList("azul", "branco"));
        Dao.updateProduct(product);
    }}
