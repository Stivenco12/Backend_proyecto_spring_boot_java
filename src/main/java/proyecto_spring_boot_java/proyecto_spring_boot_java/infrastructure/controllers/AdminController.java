package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Admin;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IAdminService;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping
    public List<Admin> list() {
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.findById(id);
        if (adminOptional.isPresent()) {
            return ResponseEntity.ok(adminOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.save(admin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.update(id, admin);
        if (adminOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(adminOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.delete(id);
        if (adminOptional.isPresent()) {
            return ResponseEntity.ok(adminOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            String message = "Error in field '" + err.getField() + "': " + err.getDefaultMessage();
            response.put("error", message);
        });
        return ResponseEntity.badRequest().body(response);
    }
}
