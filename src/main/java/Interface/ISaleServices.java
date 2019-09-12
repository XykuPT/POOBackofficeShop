package Interface;

import model.Order;
import model.Sale;

import java.util.List;

/**
 * Interface de Serviços de produtos que liga os controladores das views à base de dados
 */
public interface ISaleServices {

    /**
     * Retorna a Listagem de Vendas
     * @return Retorna a Listagem de Vendas
     */
    List<Sale> getSalesService();

    /**
     * Retorna a LIstagem de encomendas
     * @return Retorna a LIstagem de encomendas
     */
    List<Order> getOrdersService();

    /**
     * Com um Id de Vendas vai a base de dados buscar uma venda
     * @param saleId Id de Vendas
     * @return Com um Id de Vendas vai a base de dados buscar uma venda
     */
    Sale getSaleService(int saleId);

    /**
     * Venda a ser inserida na base de Dados
     * @param sale Venda a ser inserida na base de Dados
     */
    void createSaleService(Sale sale);

    /**
     * Encomenda a ser inserida na base de dados
     * @param sale Encomenda a ser inserida na base de dados
     */
    void createSaleService(Order sale);

    /**
     * Atualizar uma venda na base de dados
     * @param sale Atualizar uma venda na base de dados
     */
    void updateSaleService(Sale sale);
}
