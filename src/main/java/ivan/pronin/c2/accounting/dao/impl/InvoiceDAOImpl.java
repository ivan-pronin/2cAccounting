package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.criteria.CriteriaFactory;
import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.model.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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

    private List<Invoice> products;

    public InvoiceDAOImpl() {
    }

    @Transactional
    @Override
    public List<Invoice> getAll() {
        Criteria criteria = getCriteria();
        List<Invoice> invoices = criteria.list();
        for (Invoice i : invoices) {
            System.out.println(i);
        }
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

    private List<Invoice> getInvoicesFromResult(Criteria criteria) {
        List<Invoice> result = criteria.list();
        if (result.isEmpty()) {
            System.err.println("No invoices were found");
            return Collections.emptyList();
        } else {
            return result;
        }
    }

    private Criteria getCriteria() {
        return criteriaFactory.getCriteria(Invoice.class);
    }
}
