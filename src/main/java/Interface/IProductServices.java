package Interface;

import model.Product;

import java.util.List;

/**
 * Interface de servicços relacionados com produtos
 */
public interface IProductServices {

    /**
     * Serviço que retorna da base de dados a listagem de produtos
     * @return Serviço que retorna da base de dados a listagem de produtos
     */
    List<Product> getProductsService();

    /**
     * Serviço retorna um produto com base no Id inserido
     * @param prodId Id de Produto
     * @return Serviço retorna um produto com base no Id inserido
     */
    Product getProductService(int prodId);

    /**
     * Produto a ser inserido na base de dados
     * @param product Produto a ser inserido na base de dados
     */
    void createProductService(Product product);

    /**
     * Produto a ser atualizado na base de dados
     * @param product Produto a ser atualizado na base de dados
     */
    void updateProductService(Product product);

}
