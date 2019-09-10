package Services;

import Interface.ISaleServices;
import db.Dao;
import model.Order;
import model.Sale;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

/**
 * Classe de Serviços de produtos que liga os controladores das views à base de dados
 */
public class SaleServices implements ISaleServices {
    public static SaleServices getInstance(){ return new SaleServices();}

    /**
     * @return Retorna a Listagem de Vendas
     */
    @Override
    public List<Sale> getSalesService() {
        List<Sale> sales = (List<Sale>) Dao.getCollection("sales");
        return sales;
    }

    /**
     * @return Retorna a LIstagem de encomendas
     */
    @Override
    public List<Order> getOrdersService() {
        List<Order> orders = (List<Order>) Dao.getCollection("orders");
        return orders;
    }

    /**
     * @param saleId Id de Vendas
     * @return Com um Id de Vendas vai a base de dados buscar uma venda
     */
    @Override
    public Sale getSaleService(int saleId) {
        Sale sale = (Sale) Dao.getDocument(saleId, "sales");
        return sale;
    }

    /**
     * @param sale Venda a ser inserida na base de Dados
     */
    @Override
    public void createSaleService(Sale sale) {

        Dao.insertSale(sale);
    }

    /**
     * @param sale Encomenda a ser inserida na base de dados
     */
    @Override
    public void createSaleService(Order sale) {

        Dao.insertSale(sale);
    }

    /**
     * @param sale Atualizar uma venda na base de dados
     */
    @Override
    public void updateSaleService(Sale sale) {
        Sale newSale = new Sale("sale",01, "sold", Arrays.asList("101", "102"),60, 2);
        Dao.updateSale(newSale);
    }
}
