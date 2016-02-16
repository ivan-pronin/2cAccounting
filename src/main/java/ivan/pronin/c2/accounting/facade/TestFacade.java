package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        System.err.println(" >> Setting TEXT >> " + text);
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        System.err.println(" >> Setting id >> " + id);
        invoice.setId(id);
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
