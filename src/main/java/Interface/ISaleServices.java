package Interface;

import model.Order;
import model.Sale;

import java.util.List;

public interface ISaleServices {

    List<Sale> getSalessService();

    Sale getSaleService(int saleId);

    void createSaleService(Sale sale);
    void createSaleService(Order sale);

    void updateSaleService(Sale sale);
}
