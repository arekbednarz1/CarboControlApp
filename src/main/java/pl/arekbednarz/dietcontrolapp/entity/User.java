package pl.arekbednarz.dietcontrolapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, message = "Minimum 3 znaki")
    private String firstName;

    @Size(min = 3, message = "Minimum 3 znaki")
    private String lastName;

    @Column(nullable = false, unique = true)
    @Size(max = 245)
    @Email(message = "Niepoprawny email")
    private String email;

    @Size(min = 5, message = "Minimum 5 znaków")
    private String password;

    @Transient
    private String passwordRepeat;

    @Max(1)
    @Column(columnDefinition = "INT(1) DEFAULT 0")
    private int superUser;

    private Boolean enable;


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public void setSuperUser(int superUser) {
        this.superUser = superUser;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public int getSuperUser() {
        return superUser;
    }

    public Boolean getEnable() {
        return enable;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}



