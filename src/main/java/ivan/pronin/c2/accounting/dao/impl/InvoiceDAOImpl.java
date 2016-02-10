package ivan.pronin.c2.accounting.dao.impl;

import ivan.pronin.c2.accounting.dao.interfaces.InvoiceDAO;
import ivan.pronin.c2.accounting.model.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
@Component("invoiceDAOImpl")
public class InvoiceDAOImpl implements InvoiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList projectionList;

    private List<Invoice> products;

    public InvoiceDAOImpl() {
        projectionList = Projections.projectionList();
        projectionList.add(Projections.property("id"), "id");
        projectionList.add(Projections.property("sender_id"), "sender_id");
        projectionList.add(Projections.property("reciever_id"), "reciever_id");
        projectionList.add(Projections.property("number"), "number");
        projectionList.add(Projections.property("date"), "date");
    }

    @Transactional
    public List<Invoice> getAll() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Invoice.class, "b");
        createAliases(criteria);

        List<Invoice> invoices = createInvoiceList(criteria);
        for (Invoice i :
                invoices) {
            System.out.println(i);
        }

        return invoices;
    }

    public void testRecordData(Invoice data)
    {
        System.out.println("Recording data.. :> " + data);
        System.out.println("... >> SUCCESS!!!");
    }

    public Invoice get(int senderId, int recieverId) {
        return null;
    }

    public Invoice get(int number) {
        return null;
    }

    private List<Invoice> createInvoiceList(DetachedCriteria criteria) {
        Criteria crit = criteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        crit.addOrder(Order.desc("b.number")).setProjection(projectionList).setResultTransformer(Transformers
                .aliasToBean(Invoice.class));
        return crit.list();
    }

    private void createAliases(DetachedCriteria criteria) {
        /*criteria.createAlias("b.id", "id");*/
        // criteria.createAlias("b.number", "number");
        //criteria.createAlias("b.date", "date");
    }

    public int getPrice(String name) {
        return 0;
    }

}
