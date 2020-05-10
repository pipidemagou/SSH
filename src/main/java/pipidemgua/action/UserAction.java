package pipidemgua.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.springframework.beans.factory.annotation.Qualifier;
import pipidemgua.domain.Dept;
import pipidemgua.domain.User;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pipidemgua.service.DeptService;
import pipidemgua.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements RequestAware, ModelDriven<User> {

  @Autowired
  @Qualifier("userService")
  private UserService userService;

  //因为多处用到request对象，那就直接实现接口，来得到request对象就行了
  private Map<String, Object> request;
  //模型驱动
  User user = new User();

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public User getModel() {
    return user;
  }

  @Override
  public void setRequest(Map<String, Object> map) {
    this.request = map;
  }

  /*列表展示*/
  public String list() {

    List<User> list = userService.getAllUsers();

    System.out.println(list);
    //把数据封装到request对象上
    request.put("list", list);

    return "list";
  }

  @Autowired
  @Qualifier("deptService")
  private DeptService deptService;



  //自动封装deptId
  private Integer deptId;

  public Integer getDeptId() {
    return deptId;
  }

  public void setDeptId(Integer deptId) {
    this.deptId = deptId;
  }

  /*添加员工*/
  public String addUser() {
    //根据部门id查找部门对象
    Dept dept = deptService.findDeptById(deptId);
    //设置部门与员工的关系
    user.setDept(dept);

    userService.addUser(user);
    //返回列表展示
    return "listPage";
  }

  /*为修改提供页面，其实就是回显数据*/
  public String viewUpdate() {
    System.out.println("修改之前" + user.getId());
    //得到user
    User user = userService.findUserById(this.user.getId());
    System.out.println("修改之后" + user.getId());
    //得到所有的部门
    List<Dept> deptList = deptService.getAllDept();
    request.put("deptList", deptList);

    //使用Struts2的回显技术
    ValueStack valueStack = ActionContext.getContext().getValueStack();
    valueStack.pop();
    valueStack.push(user);
    return "viewUpdate";
  }
  /*确认修改员工，模型驱动会把数据直接封装到user对象中*/
  public String updateUser() {
    //得到部门
    Dept dept = deptService.findDeptById(deptId);
    //设置员工与部门的关系
    user.setDept(dept);
    userService.updateUser(user);
    //修改完，返回展示列表
    return "listPage";
  }
  /*删除员工*/
  public String delete() {
    System.out.println("删除之前" + user.getId());
    userService.deleteUser(user.getId());
    System.out.println("删除之后" + user.getId());
    //修改完，返回展示列表
    return "listPage";
  }
  /*添加员工...给出添加的JSP页面*/
  public String viewAdd() {
    //在添加员工的时候需要得到所有的部门信息
    List<Dept> deptList = deptService.getAllDept();
    //封装到request域对象中
    request.put("deptList", deptList);
    return "viewAdd";
  }
}
