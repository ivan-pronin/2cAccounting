package ivan.pronin.c2.accounting.dao.interfaces;

import ivan.pronin.c2.accounting.model.Invoice;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
public interface InvoiceDAO {

    List<Invoice> getAll();

    List<Invoice> getInvoiceBySenderRecieverId(int senderId, int recieverId);

    List<Invoice> getInvoiceByNumber(long number);
}
