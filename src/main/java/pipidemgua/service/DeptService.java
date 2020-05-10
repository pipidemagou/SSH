package pipidemgua.service;

import org.springframework.beans.factory.annotation.Qualifier;
import pipidemgua.dao.DeptDao;
import pipidemgua.domain.Dept;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DeptService {

  @Autowired
  @Qualifier("deptDao")
  private DeptDao deptDao;

  /**
   * 1.查找所有的部门【在添加员工、修改员工时需要用】-->getAll()
   * 2.通过id查找所在的部门信息--->find()
   */
  public List<Dept> getAllDept() {
    return deptDao.getAll();
  }

  public Dept findDeptById(Integer id) {
    return deptDao.find(id);
  }
}
