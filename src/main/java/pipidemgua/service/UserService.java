package pipidemgua.service;

import org.springframework.beans.factory.annotation.Qualifier;
import pipidemgua.dao.UserDao;
import pipidemgua.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

  @Autowired
  @Qualifier("userDao")
  private UserDao userDao;


  /**
   * 1.添加员工--->add()
   * 2.修改员工--->find()
   * 3.删除员工--->delete()
   * 4.得到所有员工-->getAll()
   * 5.根据id得到员工-->find()
   */
  public void addUser(User user) {
    userDao.add(user);
  }

  public void updateUser(User user) {
    userDao.update(user);
  }

  public void deleteUser(Integer id) {
    userDao.delete(id);
  }

  public List<User> getAllUsers() {
    return userDao.getAll();
  }

  public User findUserById(Integer id) {
    return userDao.find(id);
  }

}
