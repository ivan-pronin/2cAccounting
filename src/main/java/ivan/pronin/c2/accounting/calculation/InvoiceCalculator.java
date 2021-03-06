package ivan.pronin.c2.accounting.calculation;

import ivan.pronin.c2.accounting.model.block.InvoiceBody;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Администратор on 07.03.2016.
 */
@Component
public class InvoiceCalculator {

    public BigDecimal calculateNds(final InvoiceBody invoiceBodyItem, final BigDecimal taxRate) {
        BigDecimal result = invoiceBodyItem.getProductCost();
        return taxRate != null ? result.multiply(taxRate.divide(BigDecimal.valueOf(100))) : result;
    }

    public BigDecimal calculateProductCost(final InvoiceBody invoiceBodyItem) {
        BigDecimal result = invoiceBodyItem.getProductPrice();
        final BigDecimal productAmount = invoiceBodyItem.getProductAmount();
        return productAmount != null ? result.multiply(productAmount) : productAmount;
    }

    public BigDecimal calculateTotalCost(final InvoiceBody invoiceBodyItem) {
        BigDecimal productCost = invoiceBodyItem.getProductCost();
        BigDecimal taxCost = invoiceBodyItem.getNdsCost();
        return productCost.add(taxCost);
    }

}
