package pipidemgua.service;

import org.springframework.beans.factory.annotation.Qualifier;
import pipidemgua.dao.AdminDao;
import pipidemgua.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminService {

  @Autowired
  @Qualifier("adminDao")
  private AdminDao adminDao;

  /**
   * 1.保存管理员【注册】--->save() 2.查找管理员【登陆】--->login()
   */
  public void register(Admin admin) {

    adminDao.add(admin);
  }

  public Admin login(Admin admin) {

    return adminDao.login(admin);
  }

}
