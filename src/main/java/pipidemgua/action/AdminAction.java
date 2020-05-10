package pipidemgua.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pipidemgua.domain.Admin;
import pipidemgua.domain.User;
import pipidemgua.service.AdminService;
import pipidemgua.service.UserService;

@Controller
@Scope("prototype")

public class AdminAction extends ActionSupport implements ModelDriven<Admin>, RequestAware {

  @Autowired
  @Qualifier("userService")
  private UserService userService;
  private Map<String, Object> request;

  @Override
  public void setRequest(Map<String, Object> map) {
    this.request = map;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  /**********调用service**************/
  @Autowired
  @Qualifier("adminService")
  private AdminService adminService;


  /**************使用模型驱动******************/
  Admin admin = new Admin();

  public Admin getAdmin() {
    return admin;
  }

  public void setAdmin(Admin admin) {
    this.admin = admin;
  }

  @Override
  public Admin getModel() {
    return admin;
  }

  /*得到JSP页面带过来的数据、完成注册*/
  public String register() {
    adminService.register(admin);
    return "listPage";
  }

  /*完成登陆*/
  public String login() {
    adminService.login(admin);
    List<User> list = userService.getAllUsers();

    System.out.println(list);
    //把数据封装到request对象上
    request.put("list", list);
    //把用户保存在Sessiion中
    ActionContext.getContext().getSession().put("admin", admin);
    return "listPage";
  }

}
