package ivan.pronin.c2.accounting.model.factory;

import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import ivan.pronin.c2.accounting.model.Invoice;
import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 21.02.2016.
 */
public class InvoiceFactory implements IInvoiceFactory {

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

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Invoice createInvoice(HeaderData headerData, InvoiceBody invoiceBody) {
        productName = invoiceBody.getProductName();
        productId = productDAO.getProductIdByName(productName);

        return new Invoice(headerData, invoiceBody, productId);
    }

    @Override
    public List<Invoice> createInvoices(List<HeaderData> headerDataList, List<InvoiceBody> invoiceBodyList) {
        final int size = headerDataList.size();
        if (size != invoiceBodyList.size()) {
            throw new IllegalArgumentException("Could not build Invoices due to lists size mismatch");
        } else {
            List<Invoice> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                results.add(createInvoice(headerDataList.get(i), invoiceBodyList.get(i)));
            }
            return results;
        }
    }
}
