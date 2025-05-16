package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.AuthenticationRequest;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.AuthenticationResponse;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){
        boolean isTokenValid = authenticationService.validateToken(jwt);
        return ResponseEntity.ok(isTokenValid);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest authenticationRequest){

        AuthenticationResponse rsp = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(rsp);
    }
}
