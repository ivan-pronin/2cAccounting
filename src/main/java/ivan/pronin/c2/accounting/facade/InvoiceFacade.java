package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.calculation.InvoiceCalculator;
import ivan.pronin.c2.accounting.dao.interfaces.IncomePositionDAO;
import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.dao.interfaces.StorageDAO;
import ivan.pronin.c2.accounting.model.IncomePosition;
import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.Product;
import ivan.pronin.c2.accounting.model.Storage;
import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import ivan.pronin.c2.accounting.model.factory.IInvoiceFactory;

import ivan.pronin.c2.accounting.ui.UiRenderer;
import ivan.pronin.c2.accounting.util.FacesUtils;
import ivan.pronin.c2.accounting.util.ProductUtils;
import ivan.pronin.c2.accounting.util.TransactionDirection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 10.02.2016.
 */
@Component
@SessionScoped
public class InvoiceFacade implements Serializable {

    @Autowired
    private IInvoiceFactory invoiceFactory;

    @Autowired
    private InvoiceCalculator invoiceCalculator;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private StorageDAO storageDAO;

    @Autowired
    private IncomePositionDAO incomePositionDAO;

    @Autowired
    private UiRenderer uiRenderer;

    private static final Logger LOGGER = LogManager.getLogger(InvoiceFacade.class);

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private List<HeaderData> inHeaderDataList = new ArrayList<>();
    private List<InvoiceBody> inInvoiceBodyList = new ArrayList<>();
    private List<HeaderData> outHeaderDataList = new ArrayList<>();
    private List<InvoiceBody> outInvoiceBodyList = new ArrayList<>();

    private HeaderData headerDataItem = new HeaderData();
    private InvoiceBody invoiceBodyItem = new InvoiceBody();

    public InvoiceFacade() {
        inHeaderDataList.add(headerDataItem);
        inInvoiceBodyList.add(invoiceBodyItem);
        outHeaderDataList.add(headerDataItem);
        outInvoiceBodyList.add(invoiceBodyItem);
    }

    public void addInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        int activeTabIndex = uiRenderer.getActiveTabIndex();
        if (TransactionDirection.isInDirection(activeTabIndex)) {
            inInvoiceBodyList.add(invoiceBodyItem);
        } else if (TransactionDirection.isOutDirection(activeTabIndex)) {
            outInvoiceBodyList.add(invoiceBodyItem);
        } else {
            LOGGER.error("Could not add new Invoice row for activeTabIndex: " + activeTabIndex);
        }
    }

    @Transactional
    public void submitInvoiceForm() {
        for (InvoiceBody item : inInvoiceBodyList) {
            LOGGER.info("Printing InvoiceBody item: " + item);
        }

        for (HeaderData item : inHeaderDataList) {
            LOGGER.info("Printing Header item: " + item);
        }

        for (InvoiceBody item : inInvoiceBodyList) {
            Long invoiceId = processAndSaveInvoiceData(item, headerDataItem);
        }
    }

    private Long processAndSaveInvoiceData(InvoiceBody invoiceBodyItem, HeaderData headerDataItem) {
        Invoice invoice = invoiceFactory.createInvoice(headerDataItem, invoiceBodyItem);
        Long invoiceId = invoiceDAO.saveInvoice(invoice);
        Storage storage = new Storage(invoice.getNumber(), invoice.getProductId(), invoice.getProductAmount());
        storageDAO.updateStorage(storage);
        IncomePosition incomePosition = new IncomePosition(headerDataItem, invoiceBodyItem, invoiceId);
        Long incomePositionId = incomePositionDAO.addIncomePosition(incomePosition);
        if (invoiceId > 0 && incomePositionId != null) {
            FacesUtils.printUIMessage("Запись успешно добавлена. ID: ", invoiceId);
        }
        return invoiceId;
    }

    public void clearInvoiceForm() {
        LOGGER.info("Clearing the form ...");
        inHeaderDataList.clear();
        inInvoiceBodyList.clear();
        addInvoiceItemRow();
        addHeaderItem();
    }

    public void calculateProductCost() {
        invoiceBodyItem.setProductCost(invoiceCalculator.calculateProductCost(invoiceBodyItem));
        calculateNds();
        calculateTotalCost();
    }

    private void calculateNds() {
        invoiceBodyItem.setNdsCost(invoiceCalculator.calculateNds(invoiceBodyItem, headerDataItem.getTaxRate()
                .getValue()));
    }

    private void calculateTotalCost() {
        invoiceBodyItem.setTotalCost(invoiceCalculator.calculateTotalCost(invoiceBodyItem));
    }

    private void addHeaderItem() {
        headerDataItem = new HeaderData();
        inHeaderDataList.add(headerDataItem);
    }

    public List<HeaderData> getInHeaderDataList() {
        return inHeaderDataList;
    }

    public List<InvoiceBody> getInInvoiceBodyList() {
        return inInvoiceBodyList;
    }

    public List<HeaderData> getOutHeaderDataList() {
        return outHeaderDataList;
    }

    public List<InvoiceBody> getOutInvoiceBodyList() {
        return outInvoiceBodyList;
    }

}