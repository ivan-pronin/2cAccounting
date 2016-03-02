package ivan.pronin.c2.accounting.model;

import ivan.pronin.c2.accounting.model.block.HeaderData;
import ivan.pronin.c2.accounting.model.block.InvoiceBody;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Администратор on 27.01.2016.
 */
public class Invoice {
    private Long id;
    private Long number;
    private Date date;
    private Long senderId;
    private Long recieverId;
    private Long productId;
    private Long productAmount;
    private BigDecimal productPrice;
    private BigDecimal productCost;
    private Long ndsId;
    private BigDecimal ndsCost;
    private BigDecimal totalCost;

    public Invoice() {
    }

    public Invoice(HeaderData headerData, InvoiceBody invoiceBody, Long productId) {
        this(headerData.getNumber(), headerData.getDate(), headerData.getSenderOrg().getId(), headerData.getRecieverOrg().getId(),
                productId, invoiceBody.getProductAmount(), invoiceBody.getProductPrice(), invoiceBody.getProductCost(),
                headerData.getTaxRate().getId(), invoiceBody.getNdsCost(), invoiceBody.getTotalCost());
    }

    public Invoice(Long number, Date date, Long senderId, Long recieverId, Long productId, Long productAmount,
                   BigDecimal productPrice, BigDecimal productCost, Long ndsId, BigDecimal ndsCost, BigDecimal
                           totalCost) {
        this.number = number;
        this.date = date;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.productId = productId;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.productCost = productCost;
        this.ndsId = ndsId;
        this.ndsCost = ndsCost;
        this.totalCost = totalCost;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public Long getNdsId() {
        return ndsId;
    }

    public void setNdsId(Long ndsId) {
        this.ndsId = ndsId;
    }

    public BigDecimal getNdsCost() {
        return ndsCost;
    }

    public void setNdsCost(BigDecimal ndsCost) {
        this.ndsCost = ndsCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (number != null ? !number.equals(invoice.number) : invoice.number != null) return false;
        if (date != null ? !date.equals(invoice.date) : invoice.date != null) return false;
        if (senderId != null ? !senderId.equals(invoice.senderId) : invoice.senderId != null) return false;
        if (recieverId != null ? !recieverId.equals(invoice.recieverId) : invoice.recieverId != null) return false;
        if (productId != null ? !productId.equals(invoice.productId) : invoice.productId != null) return false;
        if (productAmount != null ? !productAmount.equals(invoice.productAmount) : invoice.productAmount != null)
            return false;
        if (productPrice != null ? !productPrice.equals(invoice.productPrice) : invoice.productPrice != null)
            return false;
        if (productCost != null ? !productCost.equals(invoice.productCost) : invoice.productCost != null) return false;
        if (ndsId != null ? !ndsId.equals(invoice.ndsId) : invoice.ndsId != null) return false;
        if (ndsCost != null ? !ndsCost.equals(invoice.ndsCost) : invoice.ndsCost != null) return false;
        if (totalCost != null ? !totalCost.equals(invoice.totalCost) : invoice.totalCost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverId != null ? recieverId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productAmount != null ? productAmount.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productCost != null ? productCost.hashCode() : 0);
        result = 31 * result + (ndsId != null ? ndsId.hashCode() : 0);
        result = 31 * result + (ndsCost != null ? ndsCost.hashCode() : 0);
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        return result;
    }


    @Override
    public String toString()
    {
        return "<id>:" + getId() + ", <number:>" + getNumber() + ", <date:>" + getDate();
    }

}
