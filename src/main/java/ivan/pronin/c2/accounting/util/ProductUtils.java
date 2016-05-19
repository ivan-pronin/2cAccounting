package ivan.pronin.c2.accounting.util;

import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import ivan.pronin.c2.accounting.model.Organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ivan.pronin.c2.accounting.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Администратор on 31.01.2016.
 */
@Component
public class ProductUtils {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    public List<Product> completeProduct(String query) {
        List<Product> products = productDAO.getAll();
        List<Product> filteredProducts = new ArrayList<Product>();
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getName().toLowerCase().contains(query)) {
                filteredProducts.add(p);
            }
        }
        return filteredProducts;
    }
}
