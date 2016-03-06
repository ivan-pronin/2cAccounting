package ivan.pronin.c2.accounting.model.validator;

import ivan.pronin.c2.accounting.model.Organization;
import org.primefaces.validate.ClientValidator;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 06.03.2016.
 */
@Component("invoiceValidator")
@FacesValidator("invoiceValidator")
public class InvoiceValidator implements Validator, ClientValidator {

    public static final String SENDER_ORG_ID = "sender_org_select";
    public static final String RECIEVER_ORG_ID = "reciever_org_select";

    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }

    @Override
    public String getValidatorId() {
        return null;
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        System.out.println(" >>>> IN VALIDATOR");
        if (value == null) {
            return;
        }
        List<UIComponent> elements = component.getParent().getChildren();
        String senderName = getComponentValue(elements, SENDER_ORG_ID);
        String recieverName = getComponentValue(elements, RECIEVER_ORG_ID);

        if (senderName.equals(recieverName)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error: организации" +
                    " должны быть разными",
                    value + " is not a valid sender / reciever organization;"));
        }
    }

    private String getComponentValue(List<UIComponent> components, String componentId) {
        for (UIComponent c : components) {
            UIComponent found = c.findComponent(componentId);
            if (found != null) {
                return String.valueOf(((UIInput) found).getSubmittedValue());
            }
        }
        return null;
    }
}
