package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.IncomePositionDAO;
import ivan.pronin.c2.accounting.model.IncomePosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component("incomePositionDAOImpl")
public class IncomePositionDAOImpl implements IncomePositionDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LogManager.getLogger(IncomePositionDAOImpl.class);

    public IncomePositionDAOImpl() {
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(IncomePosition.class);
    }

    @Override
    public Long addIncomePosition(IncomePosition incomePosition) {
        LOGGER.info("Adding new IncomePosition");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(incomePosition);
        Long id = (Long) session.save(incomePosition);
        transaction.commit();
        return id;
    }
}
