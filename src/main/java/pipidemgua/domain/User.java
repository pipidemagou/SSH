package pipidemgua.domain;

public class User {
  private Integer id;
  private String username;
  private Dept dept;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }
}
