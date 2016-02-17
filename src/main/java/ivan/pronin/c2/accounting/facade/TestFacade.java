package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.xml.transform.sax.SAXSource;
import java.io.Serializable;

/**
 * Created by Администратор on 16.02.2016.
 */
//@Component
@ManagedBean(name="testFacade")
@SessionScoped
public class TestFacade implements Serializable {

    private Invoice invoice = new Invoice();

    private Long id;

    private String text;

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        System.err.println(" >> Setting Field >> " + field);
        this.field = field;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        System.err.println(" >> Setting id >> " + id);
        this.id = id;
    }

    public void submitForm()
    {
        System.out.println(">.>.> Submitting form with the values: ");
        System.out.println("id: " + id + " | text: " + text + " | field: " + field);
    }


/*    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException {
        if (null != event.getNewValue()) {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("name", event.getNewValue());
            System.err.println(" >>>> processValueChange: " + event.getNewValue());
        }
    }*/

    public void p2(ValueChangeEvent event)
            throws AbortProcessingException {
        if (null != event.getNewValue()) {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("name", event.getNewValue());
            System.err.println(" >>>> processValueChange: " + event.getNewValue());
        }
    }
}
