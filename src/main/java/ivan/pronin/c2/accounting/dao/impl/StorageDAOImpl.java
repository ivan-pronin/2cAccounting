package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.StorageDAO;
import ivan.pronin.c2.accounting.model.Storage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 *
 */
@Component("storageDAOImpl")
public class StorageDAOImpl implements StorageDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LogManager.getLogger(StorageDAOImpl.class);

    public StorageDAOImpl() {
    }

    @Override
    public Long updateStorage(Storage storage) {
        LOGGER.info(String.format("Updating Storage with invoiceNumber '%s' and productId '%s'", storage
                .getInvoiceNumber(), storage.getProductId()));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(storage);
        Long id = (Long) session.save(storage);
        transaction.commit();
        return id;
    }

    @Override
    public long getProductAmount(Long productId) {
        Criteria criteria = getCriteria().add(Restrictions.eq("product_id", productId));
        List<Storage> results = criteria.list();
        return results.stream().mapToLong(s -> s.getProductAmount().longValue()).sum();
    }

    private List<Storage> getStorageFromResult(Criteria criteria) {
        List<Storage> result = criteria.list();
        if (result.isEmpty()) {
            LOGGER.error("No storage data was found");
            return Collections.emptyList();
        } else {
            return result;
        }
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Storage.class);
    }
}
