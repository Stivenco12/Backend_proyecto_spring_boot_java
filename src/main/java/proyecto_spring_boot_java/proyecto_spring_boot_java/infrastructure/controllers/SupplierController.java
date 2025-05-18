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
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Supplier;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ISupplierService;

@RestController
@RequestMapping("/api/Supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping
    public List<Supplier> list() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Supplier> optional = supplierService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Supplier supplier, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Supplier supplier, @PathVariable Long id) {
        Optional<Supplier> optional = supplierService.update(id, supplier);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Supplier> optional = supplierService.delete(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
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
