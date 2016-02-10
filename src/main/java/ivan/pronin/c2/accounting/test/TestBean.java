package ivan.pronin.c2.accounting.test;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Администратор on 23.01.2016.
 */
@Component
public class TestBean {

    @Autowired
    private SessionFactory sessionFactory;

    public void test() {
        System.out.println("ivan.pronin.c2.accounting.test bean + sessionFactory = " + sessionFactory);
    }
}
