package ivan.pronin.c2.accounting.util;

import org.primefaces.event.TabChangeEvent;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Администратор on 19.04.2016.
 */
@Component
public class FacesUtils {

    public static void printUIMessage(String message, Object value) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
                message + value));
    }

    public static void printUIError(String message, Object value) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                message + value));
    }

    public void onTabChange(TabChangeEvent event) {
        printUIMessage("Tab Changed, active Tab: ", event.getTab().getTitle());
    }

}
