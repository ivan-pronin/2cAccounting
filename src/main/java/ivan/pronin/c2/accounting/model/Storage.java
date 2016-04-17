package ivan.pronin.c2.accounting.model;

import java.math.BigDecimal;

/**
 * Created by Администратор on 27.01.2016.
 */
public class Storage {
    private Long id;
    private Long invoiceNumber;
    private Long productId;
    private BigDecimal productAmount;


    public Storage() {
    }

    public Storage(Long invoiceId, Long productId, BigDecimal productAmount) {
        this.invoiceNumber = invoiceId;
        this.productId = productId;
        this.productAmount = productAmount;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceId) {
        this.invoiceNumber = invoiceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (id != null ? !id.equals(storage.id) : storage.id != null) return false;
        if (productId != null ? !productId.equals(storage.productId) : storage.productId != null) return false;
        if (productAmount != null ? !productAmount.equals(storage.productAmount) : storage.productAmount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productAmount != null ? productAmount.hashCode() : 0);
        return result;
    }
}
