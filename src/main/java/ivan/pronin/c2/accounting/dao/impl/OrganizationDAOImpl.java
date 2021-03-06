package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.OrganizationDAO;
import ivan.pronin.c2.accounting.model.Organization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.acl.LastOwnerException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
@Component
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    private final Logger LOGGER = LogManager.getLogger(OrganizationDAOImpl.class);

    @Transactional
    @Override
    public List<Organization> getAll() {
        Criteria criteria = getCriteria();
        return (List<Organization>) criteria.list();
    }

    @Transactional
    @Override
    public Organization getOrganizationById(long id) {
        LOGGER.info("Getting ORG by id: " + id);
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        return getOrganizationFromResult(criteria);
    }

    @Transactional
    @Override
    public long getIdByOrganizationName(String name) {
        return getOrganizationByName(name).getId();
    }

    @Override
    public List<Organization> findOrganizations(String name) {
        LOGGER.info("Searching organizations by name: " + name);
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        return getAllOrganizationsFromResult(criteria);
    }

    @Transactional
    @Override
    public Organization getOrganizationByName(String name) {
        LOGGER.info("Getting ORG by name: " + name);
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        return getOrganizationFromResult(criteria);
    }

    private List<Organization> getAllOrganizationsFromResult(Criteria criteria) {
        List<Organization> result = criteria.list();
        if (result.isEmpty()) {
            LOGGER.error("No organizations were found");
            return Collections.emptyList();
        } else if (result.size() > 1) {
            LOGGER.warn("More than 1 organization was found, returning all of them");
        }
        return result;
    }

    private Organization getOrganizationFromResult(Criteria criteria) {
        return getAllOrganizationsFromResult(criteria).get(0);
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Organization.class);
    }

}
