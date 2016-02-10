package ivan.pronin.c2.accounting.dao.interfaces;

import ivan.pronin.c2.accounting.model.Invoice;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
public interface InvoiceDAO {

    List<Invoice> getAll();
    Invoice get(int senderId, int recieverId);
    Invoice get(int number);
    void testRecordData(Invoice invoice);
}
