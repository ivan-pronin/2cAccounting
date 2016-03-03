package ivan.pronin.c2.accounting.model.block;

import ivan.pronin.c2.accounting.model.Product;

import java.math.BigDecimal;

/**
 * Created by Администратор on 18.02.2016.
 */
public class InvoiceBody {

    private Product product;
    private BigDecimal productPrice;
    private Long productAmount;
    private BigDecimal productCost;
    private BigDecimal ndsCost;
    private BigDecimal totalCost;

    @Override
    public String toString() {
        return "InvoiceBody{" +
                "product='" + product + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", productCost=" + productCost +
                ", ndsCost=" + ndsCost +
                ", totalCost=" + totalCost +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Long productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
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
}
