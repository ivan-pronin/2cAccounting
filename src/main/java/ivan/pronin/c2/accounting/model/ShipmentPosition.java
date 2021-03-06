package ivan.pronin.c2.accounting.model;

import java.math.BigDecimal;

/**
 * Created by Администратор on 27.01.2016.
 */
public class ShipmentPosition {
    private Long id;
    private Long senderId;
    private Long recieverId;
    private Long invoiceId;
    private Long productId;
    private Long productAmount;
    private BigDecimal shipmentCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
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

    public BigDecimal getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(BigDecimal shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipmentPosition shipmentPosition = (ShipmentPosition) o;

        if (id != null ? !id.equals(shipmentPosition.id) : shipmentPosition.id != null) return false;
        if (senderId != null ? !senderId.equals(shipmentPosition.senderId) : shipmentPosition.senderId != null) return false;
        if (recieverId != null ? !recieverId.equals(shipmentPosition.recieverId) : shipmentPosition.recieverId != null) return false;
        if (invoiceId != null ? !invoiceId.equals(shipmentPosition.invoiceId) : shipmentPosition.invoiceId != null) return false;
        if (productId != null ? !productId.equals(shipmentPosition.productId) : shipmentPosition.productId != null) return false;
        if (productAmount != null ? !productAmount.equals(shipmentPosition.productAmount) : shipmentPosition.productAmount != null)
            return false;
        if (shipmentCost != null ? !shipmentCost.equals(shipmentPosition.shipmentCost) : shipmentPosition.shipmentCost != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recieverId != null ? recieverId.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productAmount != null ? productAmount.hashCode() : 0);
        result = 31 * result + (shipmentCost != null ? shipmentCost.hashCode() : 0);
        return result;
    }
}
