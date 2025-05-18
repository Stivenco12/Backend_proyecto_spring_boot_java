package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Address;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IAddresService;

@RestController
@RequestMapping("/api/Address")
public class AddressController {
    @Autowired
    private IAddresService addressService;

    @GetMapping
    public List<Address> list() {
        return addressService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Address> AddressOptional = addressService.findById(id);
        if (AddressOptional.isPresent()) {
            return ResponseEntity.ok(AddressOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Address Address, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(Address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Address Address, @PathVariable Long id) {
        Optional<Address> AddressOptional = addressService.update(id, Address);
        if (AddressOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AddressOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Address> AddressOptional = addressService.delete(id);
        if (AddressOptional.isPresent()) {
            return ResponseEntity.ok(AddressOptional.orElseThrow());
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
