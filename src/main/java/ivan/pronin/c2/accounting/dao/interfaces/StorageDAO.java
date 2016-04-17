package ivan.pronin.c2.accounting.dao.interfaces;

import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.Storage;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
public interface StorageDAO {

    Long updateStorage(Storage storage);

    long getProductAmount(Long productId);
}
