package ivan.pronin.c2.accounting.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Администратор on 27.01.2016.
 */
public class Payment {
    private Long id;
    private Long number;
    private Timestamp date;
    private Long invoiceNumber;
    private Long senderId;
    private Long recieverId;
    private Long productId;
    private Long productAmount;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Long productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (number != null ? !number.equals(payment.number) : payment.number != null) return false;
        if (date != null ? !date.equals(payment.date) : payment.date != null) return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(payment.invoiceNumber) : payment.invoiceNumber != null)
            return false;
        if (senderId != null ? !senderId.equals(payment.senderId) : payment.senderId != null) return false;
        if (recieverId != null ? !recieverId.equals(payment.recieverId) : payment.recieverId != null) return false;
        if (productId != null ? !productId.equals(payment.productId) : payment.productId != null) return false;
        if (productAmount != null ? !productAmount.equals(payment.productAmount) : payment.productAmount != null)
            return false;
        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverId != null ? recieverId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productAmount != null ? productAmount.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
