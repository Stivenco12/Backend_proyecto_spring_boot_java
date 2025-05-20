package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import jakarta.validation.constraints.Size;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;
import java.io.Serializable;

public class SaveUser implements Serializable {

    @Size(min = 4)
    private String name;
    private String username;
    private String telefono;
    @Size(min = 8)
    private String password;
    @Size(min = 8)
    private String repeatedPassword;
    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
    public SaveUser() {}

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
