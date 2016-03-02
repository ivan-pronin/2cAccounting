package ivan.pronin.c2.accounting.model.block;

import ivan.pronin.c2.accounting.model.Organization;
import ivan.pronin.c2.accounting.model.TaxRates;

import java.util.Date;

/**
 * Created by Администратор on 18.02.2016.
 */
public class HeaderData {

    private Long number;
    private Date date;
    private Organization senderOrg;
    private Organization recieverOrg;
    private TaxRates taxRate;

    public TaxRates getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRates taxRate) {
        this.taxRate = taxRate;
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

    public Organization getSenderOrg() {
        return senderOrg;
    }

    public void setSenderOrg(Organization senderOrg) {
        this.senderOrg = senderOrg;
    }

    public Organization getRecieverOrg() {
        return recieverOrg;
    }

    public void setRecieverOrg(Organization recieverOrg) {
        this.recieverOrg = recieverOrg;
    }

    @Override
    public String toString() {
        return "HeaderData{" +
                "number=" + number +
                ", date=" + date +
                ", senderOrg=" + senderOrg +
                ", recieverOrg=" + recieverOrg +
                ", taxRate=" + taxRate +
                '}';
    }
}
