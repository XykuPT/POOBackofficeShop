package Services;

import Interface.ISaleServices;
import db.Dao;
import model.Order;
import model.Sale;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class SaleServices implements ISaleServices {
    public static SaleServices getInstance(){ return new SaleServices();}

    @Override
    public List<Sale> getSalessService() {
        List<Sale> sales = (List<Sale>) Dao.getCollection("sales");
        return sales;
    }

    @Override
    public Sale getSaleService(int saleId) {
        Sale sale = (Sale) Dao.getDocument(saleId, "sales");
        return sale;
    }

    @Override
    public void createSaleService(Sale sale) {

        Dao.insertSale(sale);
    }
    @Override
    public void createSaleService(Order sale) {

        Dao.insertSale(sale);
    }
    @Override
    public void updateSaleService(Sale sale) {
        Sale newSale = new Sale(01, "sold", Arrays.asList("101", "102"),60, 2);
        Dao.updateSale(newSale);
    }
}
