package hico.group.assesment.demo.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private boolean isEnabled = true;
    private String firstName;
    private String lastName;
    private String email;
    private int roleId;
    @Column(name = "createdAt")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private final Date createdAt = new Date();
    @UpdateTimestamp
    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private final Date updatedAt = new Date();

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getUserDetails() {
        return new JSONObject()
                .put("id", id)
                .put("username", username)
                .put("isEnabled", isEnabled)
                .put("firstName", firstName)
                .put("lastName", lastName)
                .put("email", email)
                .put("roleId", roleId)
                .put("createdAt", createdAt)
                .put("updatedAt", updatedAt).toString();
    }
}
