package ivan.pronin.c2.accounting.model.converter;

import ivan.pronin.c2.accounting.dao.impl.TaxRatesDAOImpl;
import ivan.pronin.c2.accounting.dao.interfaces.TaxRatesDAO;
import ivan.pronin.c2.accounting.model.TaxRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Created by Администратор on 29.02.2016.
 */
@Component
public class TaxRatesConverter implements Converter {

    @Autowired
    private TaxRatesDAO taxRatesDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            return taxRatesDAO.getTaxById(Long.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid TaxRate ID", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (value instanceof TaxRates) {
            return String.valueOf(((TaxRates) value).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid TaxRate", value)));
        }
    }
}
