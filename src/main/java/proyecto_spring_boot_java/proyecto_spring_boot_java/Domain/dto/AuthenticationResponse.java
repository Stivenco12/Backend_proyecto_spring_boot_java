package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import java.io.Serializable;

import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;
public class AuthenticationResponse implements Serializable {
    private String jwt;
    private Long userId;
    private Role role;
    public AuthenticationResponse() {
    }
    public AuthenticationResponse(String jwt, Long userId, Role role) {
        this.role = role;
        this.jwt = jwt;
        this.userId = userId;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}