package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.ProductDAO;
import ivan.pronin.c2.accounting.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
    private CriteriaFactory criteriaFactory;

    private final Logger LOGGER = LogManager.getLogger(ProductDAOImpl.class);

    private List<Product> products;

    @Transactional
    @Override
    public List<Product> getAll() {
        Criteria criteria = getCriteria();
        products = (List<Product>) criteria.list();
        LOGGER.info("Printing all products. Total found: " + products.size());
        return products;
    }

    @Transactional
    @Override
    public Long getProductIdByName(String name) {
        return getProductByName(name).getId();
    }

    @Transactional
    @Override
    public Product getProductByName(String name) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        List<Product> result = criteria.list();
        if (isResultFound(result, "name", name)) {
            return result.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public Product getProductById(long id) {
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        List<Product> result = criteria.list();
        if (isResultFound(result, "id", "" + id)) {
            return result.get(0);
        }
        return null;
    }

    private boolean isResultFound(List<Product> result, String name, String value) {
        if (result.isEmpty()) {
            LOGGER.error(String.format("No products were found by %s: %s", name, value));
            return false;
        } else if (result.size() > 1) {
            LOGGER.warn("More than 1 result was found, returning first one");
        }
        return true;
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Product.class);
    }
}
