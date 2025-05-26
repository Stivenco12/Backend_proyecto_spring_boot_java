package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.RegisteredUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.auth.AuthenticationService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IUserService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser){
        newUser.setRole(Role.ROLE_SUPPLIER);
        System.out.println("Proveedor recibido: " + newUser.getUsername());
        RegisteredUser registeredUser = authenticationService.registerOneSupplier(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllSuppliers() {
        List<User> suppliers = userService.getAllUsers().stream()
                .filter(user -> user.getRole() == Role.ROLE_SUPPLIER)
                .collect(Collectors.toList());

        return ResponseEntity.ok(suppliers);
    }
}