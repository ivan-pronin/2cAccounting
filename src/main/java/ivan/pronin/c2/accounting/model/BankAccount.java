package ivan.pronin.c2.accounting.model;

import java.math.BigDecimal;

/**
 * Created by Администратор on 04.03.2016.
 */
public class BankAccount {
    private Long id;
    private Long paymentId;
    private BigDecimal incomeAmount;
    private BigDecimal outcomeAmount;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getOutcomeAmount() {
        return outcomeAmount;
    }

    public void setOutcomeAmount(BigDecimal outcomeAmount) {
        this.outcomeAmount = outcomeAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (incomeAmount != null ? !incomeAmount.equals(that.incomeAmount) : that.incomeAmount != null) return false;
        if (outcomeAmount != null ? !outcomeAmount.equals(that.outcomeAmount) : that.outcomeAmount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (incomeAmount != null ? incomeAmount.hashCode() : 0);
        result = 31 * result + (outcomeAmount != null ? outcomeAmount.hashCode() : 0);
        return result;
    }
}
