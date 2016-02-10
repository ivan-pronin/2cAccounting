package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.interfaces.OrganizationDAO;
import ivan.pronin.c2.accounting.model.Organization;
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
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Organization> organizations;

    @Transactional
    @Override
    public List<Organization> getAll() {

        Criteria criteria = getCriteria();
        organizations = (List<Organization>) criteria.list();
        return organizations;
    }

    @Override
    public Organization get(String name) {
        return null;
    }


    private Criteria getCriteria() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Organization.class);
        criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }

}
