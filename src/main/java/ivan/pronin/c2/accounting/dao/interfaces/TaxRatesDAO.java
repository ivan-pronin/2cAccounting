package ivan.pronin.c2.accounting.dao.interfaces;

import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.TaxRates;
import ivan.pronin.c2.accounting.model.enums.TaxType;

import java.util.List;

/**
 * Created by Администратор on 26.02.2016.
 */
public interface TaxRatesDAO {

    Long getIdByName(TaxType taxType);

    TaxRates getTaxById(Long id);

    List<TaxRates> getAll();
}
