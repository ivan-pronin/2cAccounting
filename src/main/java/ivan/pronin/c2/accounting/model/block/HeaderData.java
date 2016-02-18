package ivan.pronin.c2.accounting.model.block;

import java.sql.Timestamp;

/**
 * Created by Администратор on 18.02.2016.
 */
public class HeaderData {

    private Long number;
    private Timestamp date;
    private Long senderId;
    private Long recieverId;

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

    @Override
    public String toString() {
        return "HeaderData{" +
                "number=" + number +
                ", date=" + date +
                ", senderId=" + senderId +
                ", recieverId=" + recieverId +
                '}';
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }
}
