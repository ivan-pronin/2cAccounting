package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.OrganizationDAO;
import ivan.pronin.c2.accounting.model.Organization;
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
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Transactional
    @Override
    public List<Organization> getAll() {
        Criteria criteria = getCriteria();
        return (List<Organization>) criteria.list();
    }

    @Transactional
    @Override
    public Organization getOrganizationById(long id) {
        System.out.println(" ... Getting ORG by id: " + id);
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        return getOrganizationFromResult(criteria);
    }

    @Transactional
    @Override
    public long getIdByOrganizationName(String name) {
        return getOrganizationByName(name).getId();
    }

    @Transactional
    @Override
    public Organization getOrganizationByName(String name) {
        System.out.println(" ... Getting ORG by name: " + name);
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        return getOrganizationFromResult(criteria);
    }

    private Organization getOrganizationFromResult(Criteria criteria) {
        List<Organization> result = criteria.list();
        if (result.isEmpty()) {
            System.out.println("No organizations were found");
            return null;
        } else if (result.size() > 1) {
            System.out.println("More than 1 organization found, returning first one");
        }
        System.out.println("Returning ORG: " + result.get(0));
        return result.get(0);
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Organization.class);
    }

}
