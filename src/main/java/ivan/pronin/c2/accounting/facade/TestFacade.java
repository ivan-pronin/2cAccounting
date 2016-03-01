package ivan.pronin.c2.accounting.facade;

import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Администратор on 16.02.2016.
 */
@Component
@SessionScoped
public class TestFacade implements Serializable {

    @Autowired
    private InvoiceDAO IInvoiceDAO;

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    public void testGetList(){
        System.out.println(productDAO.getProductById(1));
        System.out.println(productDAO.getProductIdByName("Вилка"));
    }
}
