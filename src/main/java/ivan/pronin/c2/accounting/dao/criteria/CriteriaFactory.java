package ivan.pronin.c2.accounting.dao.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Администратор on 21.02.2016.
 */
@Component
public class CriteriaFactory implements ICriteriaFactory {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public <T> Criteria getCriteria(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }
}
