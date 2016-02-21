package ivan.pronin.c2.accounting.dao.interfaces;

import ivan.pronin.c2.accounting.model.Product;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
public interface ProductDAO {

    List<Product> getAll();

    Product getProductByName(String name);

    Product getProductById(long id);

    Long getProductIdByName(String name);
}
