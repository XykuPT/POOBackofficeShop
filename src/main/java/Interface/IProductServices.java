package Interface;

import model.Product;

import java.util.List;

/**
 * Interface de servicços relacionados com produtos
 */
public interface IProductServices {

    /**
     * @return Serviço que retorna da base de dados a listagem de produtos
     */
    List<Product> getProductsService();

    /**
     * @param prodId Id de Produto
     * @return Serviço retorna um produto com base no Id inserido
     */
    Product getProductService(int prodId);

    /**
     * @param product Produto a ser inserido na base de dados
     */
    void createProductService(Product product);

    /**
     * @param product Produto a ser atualizado na base de dados
     */
    void updateProductService(Product product);

}
