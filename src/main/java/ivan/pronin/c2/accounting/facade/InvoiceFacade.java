package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 10.02.2016.
 */
@Component
@Scope("singleton")
//@ManagedBean(name = "invoiceFacade")
//@SessionScoped
public class InvoiceFacade implements Serializable {

    private List<HeaderData> headerDataList;
    private List<InvoiceBody> invoiceBodyList;

    private HeaderData headerDataItem;
    private InvoiceBody invoiceBodyItem;

    public InvoiceFacade() {
        headerDataList = new ArrayList<>();
        invoiceBodyList = new ArrayList<>();
        headerDataItem = new HeaderData();
        invoiceBodyItem = new InvoiceBody();
        headerDataList.add(headerDataItem);
        invoiceBodyList.add(invoiceBodyItem);
    }

    public List<HeaderData> getHeaderDataList() {
        return headerDataList;
    }

    public List<InvoiceBody> getInvoiceBodyList() {
        return invoiceBodyList;
    }

    public void addInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        invoiceBodyList.add(invoiceBodyItem);
    }

    public void submitForm() {
        for (InvoiceBody item : invoiceBodyList) {
            System.out.println("Printing item: " + item);
        }
    }

    public void clearForm() {
        System.out.println("Clearing the form ...");
        headerDataList.clear();
        invoiceBodyList.clear();
    }
}
