package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import java.io.Serializable;


public class AuthenticationResponse implements Serializable {
    private String jwt;
    private Long userId;
    private String role;

    public AuthenticationResponse() {
    }
    public AuthenticationResponse(String jwt, Long userId, String role) {
        this.jwt = jwt;
        this.userId = userId;
        this.role = role != null ? role.toUpperCase().trim() : null;
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

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

}