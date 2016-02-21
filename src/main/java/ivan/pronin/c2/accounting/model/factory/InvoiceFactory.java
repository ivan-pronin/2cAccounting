package ivan.pronin.c2.accounting.model.factory;

import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Администратор on 21.02.2016.
 */
public class InvoiceFactory implements IInvoiceFactory{

    private Long id;
    private Long number;
    private Timestamp date;
    private Long senderId;
    private Long recieverId;
    private Long productId;
    private String productName;
    private Long productAmount;
    private BigDecimal productPrice;
    private BigDecimal productCost;
    private Long ndsId;
    private BigDecimal ndsCost;
    private BigDecimal totalCost;

    @Override
    public Invoice createInvoice(HeaderData headerData, InvoiceBody invoiceBody) {
       Invoice invoice = new Invoice();
        number = headerData.getNumber();
        date = headerData.getDate();
        senderId = headerData.getSenderId();
        recieverId = headerData.getRecieverId();

        productName = invoiceBody.getProductName();
        productPrice = invoiceBody.getProductPrice();
        productAmount = invoiceBody.getProductAmount();
        productCost = invoiceBody.getProductCost();
        ndsCost = invoiceBody.getNdsCost();
        totalCost = invoiceBody.getTotalCost();

        invoice = new Invoice();
    }

    @Override
    public List<Invoice> createInvoices(List<HeaderData> headerDataList, List<InvoiceBody> invoiceBodyList) {
        return null;
    }
}
