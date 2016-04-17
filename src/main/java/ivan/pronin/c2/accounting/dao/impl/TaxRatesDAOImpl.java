package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.TaxRatesDAO;
import ivan.pronin.c2.accounting.model.Product;
import ivan.pronin.c2.accounting.model.TaxRates;
import ivan.pronin.c2.accounting.model.enums.TaxType;
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
public class TaxRatesDAOImpl implements TaxRatesDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    private static final Logger LOGGER = LogManager.getLogger(TaxRatesDAOImpl.class);

    @Transactional
    @Override
    public Long getIdByName(TaxType taxType) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", taxType.name(), MatchMode.ANYWHERE));
        List<TaxRates> result = criteria.list();
        if (isResultFound(result, taxType, "taxType"))
        {
            return result.get(0).getId();
        }
        return null;
    }

    @Transactional
    @Override
    public TaxRates getTaxById(Long id) {
        LOGGER.info("Getting tax by id: " + id);
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        List<TaxRates> result = criteria.list();
        if (isResultFound(result, id, "id"))
        {
            return result.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public List<TaxRates> getAll() {
        return getCriteria().list();
    }

    private boolean isResultFound(List<TaxRates> result, Object value, String name)
    {
        if (result.isEmpty()) {
            LOGGER.error(String.format("No taxes were found by %s: %s", name, value));
            return false;
        } else if (result.size() > 1) {
            LOGGER.warn("More than 1 result found, returning first one");
        }
        return true;
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(TaxRates.class);
    }
}
