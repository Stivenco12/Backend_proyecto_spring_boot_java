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
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Tools;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IToolsService;

@RestController
@RequestMapping("/api/Tools")
public class ToolsController {

    @Autowired
    private IToolsService toolsService;

    @GetMapping
    public List<Tools> list() {
        return toolsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Tools> optional = toolsService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Tools tool, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(toolsService.save(tool));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tools tool, @PathVariable Long id) {
        Optional<Tools> optional = toolsService.update(id, tool);
        if (optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Tools> optional = toolsService.delete(id);
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
