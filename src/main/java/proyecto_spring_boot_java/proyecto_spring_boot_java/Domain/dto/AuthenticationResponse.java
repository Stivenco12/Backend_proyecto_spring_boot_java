package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import java.io.Serializable;
public class AuthenticationResponse implements Serializable {
    private String jwt;
    private Long userId;
    public AuthenticationResponse() {
    }
    public AuthenticationResponse(String jwt, Long userId) {
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
}