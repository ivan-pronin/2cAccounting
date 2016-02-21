package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 10.02.2016.
 */
@Component
@Scope("singleton")
public class InvoiceFacade implements Serializable {

    private List<HeaderData> inHeaderDataList;
    private List<InvoiceBody> inInvoiceBodyList;
    private List<HeaderData> outHeaderDataList;
    private List<InvoiceBody> outInvoiceBodyList;

    private HeaderData headerDataItem;
    private InvoiceBody invoiceBodyItem;

    public InvoiceFacade() {
        inHeaderDataList = new ArrayList<>();

        inInvoiceBodyList = new ArrayList<>();
        outHeaderDataList = new ArrayList<>();
        outInvoiceBodyList = new ArrayList<>();

        headerDataItem = new HeaderData();
        invoiceBodyItem = new InvoiceBody();
        inHeaderDataList.add(headerDataItem);
        inInvoiceBodyList.add(invoiceBodyItem);
        outHeaderDataList.add(headerDataItem);
        outInvoiceBodyList.add(invoiceBodyItem);
    }

    public List<HeaderData> getInHeaderDataList() {
        return inHeaderDataList;
    }

    public List<InvoiceBody> getInInvoiceBodyList() {
        return inInvoiceBodyList;
    }

    public List<HeaderData> getOutHeaderDataList() { return outHeaderDataList; }

    public List<InvoiceBody> getOutInvoiceBodyList() { return outInvoiceBodyList; }

    public void addInInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        inInvoiceBodyList.add(invoiceBodyItem);
    }

    public void addOutInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        outInvoiceBodyList.add(invoiceBodyItem);
    }

    public void submitInInvoiceForm() {
        for (InvoiceBody item : inInvoiceBodyList) {
            System.out.println("Printing item: " + item);
        }
    }

    public void submitOutInvoiceForm() {
        for (InvoiceBody item : outInvoiceBodyList) {
            System.out.println("Printing item: " + item);
        }
    }

    public void clearInForm() {
        System.out.println("Clearing the In forms ...");
        inHeaderDataList.clear();
        inInvoiceBodyList.clear();
        addInInvoiceItemRow();
    }

    public void clearOutForm() {
        System.out.println("Clearing the Out forms ...");
        outHeaderDataList.clear();
        outInvoiceBodyList.clear();
        addOutInvoiceItemRow();
    }
}
