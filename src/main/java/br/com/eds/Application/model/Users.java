package br.com.eds.Application.model;

import br.com.eds.Application.model.enumModel.Gender;
import br.com.eds.Application.model.enumModel.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Users extends AbstractEntity{

    @Length(min = 6, message = "O valor não pode ser menor que 6 caracteres")
    private  String name;

    @Length(min = 6, message = "O valor não pode ser menor que 6 caracteres")
    private String login;

    @Length(min = 6, message = "O valor não pode ser menor que 6 caracteres")
    private String password;

    private Integer role;

    private Integer gender;

    public Gender getGender() {
        return Gender.toEnum(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }

    public Role getRole() {
        return Role.toEnum(role);
    }

    public void setRole(Role role) {
        this.role = role.getCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(role, users.role) &&
                Objects.equals(gender, users.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, login, password, role, gender);
    }
}
