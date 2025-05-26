package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import jakarta.validation.Valid;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.RegisteredUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.auth.AuthenticationService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IUserService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser){
        newUser.setRole(Role.ROLE_CUSTOMER);
        System.out.println("Usuario recibido: " + newUser.getUsername());
        RegisteredUser registeredUser = authenticationService.registerOneCustomer(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllSuppliers() {
        List<User> suppliers = userService.getAllUsers().stream()
                .filter(user -> user.getRole() == Role.ROLE_CUSTOMER)
                .collect(Collectors.toList());

        return ResponseEntity.ok(suppliers);
    }
}