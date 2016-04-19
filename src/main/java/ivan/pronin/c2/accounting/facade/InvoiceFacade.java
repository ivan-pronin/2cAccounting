package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.calculation.InvoiceCalculator;
import ivan.pronin.c2.accounting.dao.interfaces.IncomePositionDAO;
import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import ivan.pronin.c2.accounting.dao.interfaces.StorageDAO;
import ivan.pronin.c2.accounting.model.IncomePosition;
import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.Product;
import ivan.pronin.c2.accounting.model.Storage;
import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import ivan.pronin.c2.accounting.model.factory.IInvoiceFactory;

import ivan.pronin.c2.accounting.util.FacesUtils;
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

    private static final Logger LOGGER = LogManager.getLogger(InvoiceFacade.class);

    private List<Invoice> inInvoices;
    private List<Invoice> outInvoices;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

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

    public List<HeaderData> getOutHeaderDataList() {
        return outHeaderDataList;
    }

    public List<InvoiceBody> getOutInvoiceBodyList() {
        return outInvoiceBodyList;
    }

    public void addInInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        inInvoiceBodyList.add(invoiceBodyItem);
    }

    public void addOutInvoiceItemRow() {
        invoiceBodyItem = new InvoiceBody();
        outInvoiceBodyList.add(invoiceBodyItem);
    }

    @Transactional
    public void submitInInvoiceForm() {
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
        if (invoiceId > 0 && incomePositionId != null)
        {
            FacesUtils.printUIMessage("Запись успешно добавлена. ID: ", invoiceId);
        }
        return invoiceId;
    }

    public void submitOutInvoiceForm() {
        LOGGER.info("Submitting submitOutInvoiceForm..." + headerDataItem);
        for (InvoiceBody item : outInvoiceBodyList) {
            LOGGER.info("Printing item: " + item);
        }
    }

    public void clearInForm() {
        LOGGER.info("Clearing the In forms ...");
        inHeaderDataList.clear();
        inInvoiceBodyList.clear();
        addInInvoiceItemRow();
    }

    public void clearOutForm() {
        LOGGER.info("Clearing the Out forms ...");
        outHeaderDataList.clear();
        outInvoiceBodyList.clear();
        addOutInvoiceItemRow();
    }

    public void valueChanged() {
        LOGGER.info(" ===valueChanged ===== value: " + value);
    }

    private Product testProduct;

    public Product getTestProduct() {
        return testProduct;
    }

    public void setTestProduct(Product testProduct) {
        this.testProduct = testProduct;
    }

    public void testProduct() {

        LOGGER.info("Test product is: " + testProduct);
    }

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    public List<Product> completeProduct(String query) {
        List<Product> products = productDAO.getAll();
        List<Product> filteredProducts = new ArrayList<Product>();

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getName().toLowerCase().contains(query)) {
                filteredProducts.add(p);
            }
        }
        return filteredProducts;
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

}