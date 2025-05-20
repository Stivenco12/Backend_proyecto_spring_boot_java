package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.RegisteredUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.auth.AuthenticationService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser){
        System.out.println("Proveedor recibido: " + newUser.getUsername());
        RegisteredUser registeredUser = authenticationService.registerOneSupplier(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}