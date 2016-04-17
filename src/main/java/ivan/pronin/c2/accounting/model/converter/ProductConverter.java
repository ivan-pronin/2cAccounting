package ivan.pronin.c2.accounting.model.converter;

import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import ivan.pronin.c2.accounting.dao.interfaces.TaxRatesDAO;
import ivan.pronin.c2.accounting.model.Product;
import ivan.pronin.c2.accounting.model.TaxRates;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class ProductConverter implements Converter {

    @Autowired
    private ProductDAO productDAO;

    private static final Logger LOGGER = LogManager.getLogger(ProductConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            LOGGER.info("Converting product from value: " + value);
            Long id = Long.valueOf(value.split("\\| ")[1]);
            LOGGER.info("Found Product ID: " + id);
            return productDAO.getProductById(id);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Product", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Product) {
            return value.toString();
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Product", value)));
        }
    }
}
