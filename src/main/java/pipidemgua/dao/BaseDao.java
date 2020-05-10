package pipidemgua.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseDao<T> {

  // 容器注入sessionFactory
  @Autowired
  @Qualifier("sessionFactory")
  private SessionFactory sessionFactory;

  //子类的类型
  private Class<T> clazz;

  //子类的名称
  private final String clazzName;

  public BaseDao() {
    clazz = (Class<T>) this.getClass();  //拿到的是子类
    ParameterizedType pt = (ParameterizedType) clazz.getGenericSuperclass();

    //拿到子类的真实类型
    clazz = (Class) pt.getActualTypeArguments()[0];
    //拿到子类的名称【HQL都是通过类名来查询的】
    clazzName = clazz.getSimpleName();
  }

  public void add(T t) {
    sessionFactory.getCurrentSession().save(t);
  }

  public T find(Integer id) {
    System.out.println(clazz);
    return (T) sessionFactory.getCurrentSession().get(clazz, id);
  }

  public void update(T t) {
    sessionFactory.getCurrentSession().update(t);
  }

  public void delete(Integer id) {
    T t = (T) sessionFactory.getCurrentSession().get(clazz, id);
    sessionFactory.getCurrentSession().delete(t);
  }

  public List<T> getAll() {
    System.out.println(clazzName);
    return sessionFactory.getCurrentSession().createQuery("from" + " " + clazzName).list();
  }
}
