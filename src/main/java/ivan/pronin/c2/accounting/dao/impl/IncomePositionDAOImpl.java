package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.IncomePositionDAO;
import ivan.pronin.c2.accounting.dao.interfaces.OrganizationDAO;
import ivan.pronin.c2.accounting.model.IncomePosition;
import ivan.pronin.c2.accounting.util.FacesUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metamodel.relational.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component("incomePositionDAOImpl")
public class IncomePositionDAOImpl implements IncomePositionDAO {

    public static final String MELNIKOV_ORG = "Мельников";
    private static final String SEPARATOR = " | ";

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private OrganizationDAO organizationDAO;

    private static final Logger LOGGER = LogManager.getLogger(IncomePositionDAOImpl.class);

    public IncomePositionDAOImpl() {
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(IncomePosition.class);
    }

    @Override
    public Long addIncomePosition(IncomePosition incomePosition) {
        LOGGER.info("Adding new IncomePosition");
        if (isValid(incomePosition)) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(incomePosition);
            Long id = (Long) session.save(incomePosition);
            transaction.commit();
            return id;
        }
        return null;
    }

    private boolean isValid(IncomePosition incomePosition) {
        StringBuilder errorMessage = new StringBuilder();
        Long melnikovId = organizationDAO.findOrganizations(MELNIKOV_ORG).get(0).getId();
        if (melnikovId ==  incomePosition.getSenderId()) {
            errorMessage.append("Wrong senderId: it equals to Melnikov's: " + melnikovId);
        }
        final Long invoiceId = incomePosition.getInvoiceId();
        if (invoiceId < 1) {
            errorMessage.append(SEPARATOR + "Wrong invoiceId: " + invoiceId);
        }
        final Long productId = incomePosition.getProductId();
        if (productId < 1) {
            errorMessage.append(SEPARATOR + "Wrong productId: " + productId);
        }
        final Long productAmount = incomePosition.getProductAmount().longValue();
        if (productAmount < 1) {
            errorMessage.append(SEPARATOR + "Wrong productAmount: " + productAmount);
        }
        final Long productCost = incomePosition.getProductCost().longValue();
        if (productCost < 1) {
            errorMessage.append(SEPARATOR + "Wrong productCost: " + productCost);
        }
        if (errorMessage.length() > 0) {
            FacesUtils.printUIError("IncomePosition validation error: ", errorMessage);
            return false;
        }
        return true;
    }
}
