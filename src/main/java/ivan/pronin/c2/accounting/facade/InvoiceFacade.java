package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.dao.impl.InvoiceDAOImpl;
import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by Администратор on 10.02.2016.
 */
@Component
@Scope("singleton")
//    @ManagedBean
//    @SessionScoped
public class InvoiceFacade {

    //@ManagedProperty("#{invoiceDAOImpl}")
    @Autowired
    private InvoiceDAO invoiceDAO;


    public InvoiceDAO getInvoiceDAO() {
        return invoiceDAO;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {

        return invoice;
    }

    public void setInvoiceDAO(InvoiceDAOImpl invoiceDAO) {

        this.invoiceDAO = invoiceDAO;
    }

    private Invoice invoice = new Invoice();

    public void submit()
    {
        invoiceDAO.testRecordData(invoice);
    }

}
