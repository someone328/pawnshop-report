package io.vertx.cluster.platform.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.cluster.platform.model.Department;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Пользователь системы
 **/
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class ModelUser   {

  @
  private String id = null;

  private String name = null;

  private String login = null;

  private List<Department> department = new ArrayList<>();

  public ModelUser () {

  }

  public ModelUser (String id, String name, String login, List<Department> department) {
    this.id = id;
    this.name = name;
    this.login = login;
    this.department = department;
  }

    
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public ModelUser setId(String id) {
    this.id = id;
    return this;
  }

    
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public ModelUser setName(String name) {
    this.name = name;
    return this;
  }

    
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }
  public ModelUser setLogin(String login) {
    this.login = login;
    return this;
  }

    
  @JsonProperty("department")
  public List<Department> getDepartment() {
    return department;
  }
  public ModelUser setDepartment(List<Department> department) {
    this.department = department;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelUser _user = (ModelUser) o;
    return Objects.equals(id, _user.id) &&
        Objects.equals(name, _user.name) &&
        Objects.equals(login, _user.login) &&
        Objects.equals(department, _user.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, login, department);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelUser {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
