package ivan.pronin.c2.accounting.dao.criteria;

import org.hibernate.Criteria;

/**
 * Created by Администратор on 21.02.2016.
 */
public interface ICriteriaFactory {

    <T> Criteria getCriteria(Class<T> clazz);
}
