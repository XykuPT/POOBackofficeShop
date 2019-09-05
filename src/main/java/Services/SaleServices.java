package Services;

import Interface.ISaleServices;
import db.Dao;
import model.Sale;

import java.util.List;

public class SaleServices implements ISaleServices {
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

        Sale newSale = new Sale(01, "sold", new int[]{101, 102},60, 2);
        Dao.insertDocument(newSale, "sales" );
    }

    @Override
    public void updateSaleService(Sale sale) {
        Sale newSale = new Sale(01, "sold", new int[]{101, 102},60, 2);
        Dao.updateSale(newSale);
    }
}
