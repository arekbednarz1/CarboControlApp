package pl.arekbednarz.dietcontrolapp.web.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class LoginDTO
{
    @NotNull
    @Email
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 45)
    private String password;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + "**********" + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(email, loginDTO.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email);
    }
}
