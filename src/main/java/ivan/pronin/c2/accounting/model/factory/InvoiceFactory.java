package ivan.pronin.c2.accounting.model.factory;

import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;

import java.util.List;

/**
 * Created by Администратор on 21.02.2016.
 */
public class InvoiceFactory implements IInvoiceFactory{

    @Override
    public Invoice createInvoice(HeaderData headerData, InvoiceBody invoiceBody) {
       Invoice invoice = new Invoice();
        //TODO
        return null;
    }

    @Override
    public List<Invoice> createInvoices(List<HeaderData> headerDataList, List<InvoiceBody> invoiceBodyList) {
        return null;
    }
}
