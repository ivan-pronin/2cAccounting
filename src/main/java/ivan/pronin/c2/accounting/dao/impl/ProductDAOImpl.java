package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;

import ivan.pronin.c2.accounting.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
@Component
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

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

    @Override
    public Product get(String name) {
        return null;
    }

    @Override
    public Product get(int id) {
        return null;
    }

    private Criteria getCriteria() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Product.class);
        criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
}
