package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;

import ivan.pronin.c2.accounting.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
@Component
public class ProductDAOImpl implements ProductDAO {

    public static final String PERCENT = "%";
    @Autowired
    private CriteriaFactory criteriaFactory;

    private List<Product> products;

    @Transactional
    @Override
    public List<Product> getAll() {

        Criteria criteria = getCriteria();
        products = (List<Product>) criteria.list();
        for (Product product : products) {
            System.out.println(product);
        }
        return products;
    }

    @Transactional
    @Override
    public Product getProductByName(String name) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        List<Product> result = criteria.list();
        if (result.isEmpty()) {
            System.err.println("No products were found by name: " + name);
            return null;
        } else if (result.size() > 1) {
            System.out.println("More than 1 result found, returning first one");
        }
        return result.get(0);
    }

    @Transactional
    @Override
    public Product getProductById(long id) {
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        List<Product> result = criteria.list();
        if (result.isEmpty()) {
            System.err.println("No products were found by id: " + id);
            return null;
        } else if (result.size() > 1) {
            System.out.println("More than 1 result found, returning first one");
        }
        return result.get(0);
    }

    @Transactional
    @Override
    public Long getProductIdByName(String name) {
        return getProductByName(name).getId();
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Product.class);
    }
}
