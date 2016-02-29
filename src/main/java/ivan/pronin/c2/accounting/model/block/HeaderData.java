package ivan.pronin.c2.accounting.model.block;

import ivan.pronin.c2.accounting.model.TaxRates;

import java.sql.Timestamp;

/**
 * Created by Администратор on 18.02.2016.
 */
public class HeaderData {

    private Long number;
    private Timestamp date;
    private Long senderId;
    private String senderName;
    private String recieverName;
    private Long recieverId;
    private TaxRates taxRate;


    public String getRecieverName() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName = recieverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    @Override
    public String toString() {
        return "HeaderData{" +
                "number=" + number +
                ", date=" + date +
                ", senderName='" + senderName + '\'' +
                ", recieverName='" + recieverName + '\'' +
                ", taxRate=" + taxRate +
                '}';
    }
}
