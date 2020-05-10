package pipidemgua.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import pipidemgua.domain.Admin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao extends BaseDao<Admin> {

  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;

  public Admin login(Admin admin) {
    return (Admin) sessionFactory.
        getCurrentSession().
        createQuery("FROM Admin WHERE username=? AND password=?")
        .setParameter(0, admin.getUsername())
        .setParameter(1, admin.getPassword())
        .uniqueResult();
  }
}
