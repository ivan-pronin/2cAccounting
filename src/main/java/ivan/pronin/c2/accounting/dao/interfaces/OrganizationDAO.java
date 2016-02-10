package ivan.pronin.c2.accounting.dao.interfaces;


import ivan.pronin.c2.accounting.model.Organization;

import java.util.List;

/**
 * Created by Администратор on 24.01.2016.
 */
public interface OrganizationDAO {

    List<Organization> getAll();
    Organization get(String name);
}
