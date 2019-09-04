package Interface;

import model.Sale;

import java.util.List;

public interface ISaleServices {

    List<Sale> getSalessService();

    Sale getSaleService(int saleId);

    void createSaleService(Sale sale);

    void updateSaleService(Sale sale);
}
