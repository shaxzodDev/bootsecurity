package rc.bootsecurity.model;

import rc.bootsecurity.model.order.OrderMain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";

    @OneToMany
    private List<OrderMain> orderMains = new ArrayList<>();

//    public User(String username, String password, String roles, String permissions) {
//        this.username = username;
//        this.password = password;
//        this.active = 1;
//        this.roles = roles;
//        this.permissions = permissions;
//    }


    public User(String username,
                String email,
                String password,
                String name,
                String roles,
                String permissions) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
        this.permissions = permissions;
        this.active  = 1;
    }

    protected User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<String> getRoleList() {
        if (roles.length() > 0) {
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(permissions.split(","));
        }
        return new ArrayList<>();
    }

    public List<OrderMain> getOrderMains() {
        return orderMains;
    }

    public void setOrderMains(List<OrderMain> orderMains) {
        this.orderMains = orderMains;
    }
}
