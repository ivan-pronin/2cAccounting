package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.model.Invoice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
@Component("invoiceDAOImpl")
public class InvoiceDAOImpl implements InvoiceDAO {

    @Autowired
    private CriteriaFactory criteriaFactory;

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger LOGGER = LogManager.getLogger(InvoiceDAOImpl.class);

    public InvoiceDAOImpl() {
    }

    @Transactional
    @Override
    public List<Invoice> getAll() {
        Criteria criteria = getCriteria();
        List<Invoice> invoices = criteria.list();
        LOGGER.info("Getting all invoices. Total found: " + invoices.size());
        return invoices;
    }

    @Transactional
    @Override
    public List<Invoice> getInvoiceBySenderRecieverId(int senderId, int recieverId) {
        Criteria criteria = getCriteria().add(Restrictions.eq("sender_id", senderId)).add(Restrictions.eq
                ("reciever_id", recieverId));
        return getInvoicesFromResult(criteria);
    }

    @Transactional
    @Override
    public List<Invoice> getInvoiceByNumber(long number) {
        Criteria criteria = getCriteria().add(Restrictions.eq("number", number));
        return getInvoicesFromResult(criteria);
    }

    @Transactional
    @Override
    public Long saveInvoice(Invoice invoice) {
        LOGGER.info("Trying to save invoice: " + invoice);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(invoice);
        Long id = (Long) session.save(invoice);
        transaction.commit();
        LOGGER.info("Invoice saved with id: " + id);
        return id;
    }

    private List<Invoice> getInvoicesFromResult(Criteria criteria) {
        List<Invoice> result = criteria.list();
        if (result.isEmpty()) {
            LOGGER.error("No invoices were found");
            return Collections.emptyList();
        } else {
            return result;
        }
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Invoice.class);
    }
}
