package Interface;

import model.Order;
import model.Sale;

import java.util.List;

/**
 * Interface de Serviços de produtos que liga os controladores das views à base de dados
 */
public interface ISaleServices {

    /**
     * @return Retorna a Listagem de Vendas
     */
    List<Sale> getSalesService();

    /**
     * @return Retorna a LIstagem de encomendas
     */
    List<Order> getOrdersService();

    /**
     * @param saleId Id de Vendas
     * @return Com um Id de Vendas vai a base de dados buscar uma venda
     */
    Sale getSaleService(int saleId);

    /**
     * @param sale Venda a ser inserida na base de Dados
     */
    void createSaleService(Sale sale);

    /**
     * @param sale Encomenda a ser inserida na base de dados
     */
    void createSaleService(Order sale);

    /**
     * @param sale Atualizar uma venda na base de dados
     */
    void updateSaleService(Sale sale);
}
