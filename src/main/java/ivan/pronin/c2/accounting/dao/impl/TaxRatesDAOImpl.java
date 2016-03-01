package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.TaxRatesDAO;
import ivan.pronin.c2.accounting.model.Product;
import ivan.pronin.c2.accounting.model.TaxRates;
import ivan.pronin.c2.accounting.model.enums.TaxType;
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

    @Transactional
    @Override
    public Long getIdByName(TaxType taxType) {
        Criteria criteria = getCriteria().add(Restrictions.ilike("name", taxType.name(), MatchMode.ANYWHERE));
        List<TaxRates> result = criteria.list();
        if (result.isEmpty()) {
            System.err.println("No taxes were found by name: " + taxType.name());
            return null;
        } else if (result.size() > 1) {
            System.out.println("More than 1 result found, returning first one");
        }
        return result.get(0).getId();
    }

    @Transactional
    @Override
    public TaxRates getTaxById(Long id) {
        System.out.println(" .......          Getting tax by id: " + id);
        Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
        List<TaxRates> result = criteria.list();
        if (result.isEmpty()) {
            System.out.println("No taxes were found by id: " + id);
            return null;
        } else if (result.size() > 1) {
            System.out.println("More than 1 result found, returning first one");
        }
        return result.get(0);
    }

    @Transactional
    @Override
    public List<TaxRates> getAll() {
        return getCriteria().list();
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(TaxRates.class);
    }
}
