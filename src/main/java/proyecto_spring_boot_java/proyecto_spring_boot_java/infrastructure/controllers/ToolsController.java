package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.ToolRequestDTO;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.ToolRequestDTO2;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.CategoryType;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Tools;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IToolsService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IUserService;


@RestController
@RequestMapping("/api/Tools")
public class ToolsController {
    @Autowired
    private IToolsService toolsService;

    @Autowired
    private IUserService userService; 
    
 

    @GetMapping
    public List<Tools> list() {
        return toolsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        return toolsService.findById(id)
        
            .map(tool -> ResponseEntity.ok(tool))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createTool(
        @RequestPart("tool") ToolRequestDTO toolDto,
        @RequestPart("imagen") MultipartFile imagen
    ) {
        try {
            Tools tool = new Tools();
            tool.setName(toolDto.getName());
            tool.setDescripcion(toolDto.getDescripcion());
            tool.setCategory(CategoryType.valueOf(toolDto.getCategory()));
            tool.setDisponibilidad(toolDto.getDisponibilidad());
            tool.setCostoDiario(toolDto.getCostoDiario());
            tool.setDatosImagen(imagen.getBytes());
            
            Optional<User> userOpt = userService.findById(toolDto.getUserId());
            if (userOpt.isEmpty()) {
                return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body("Usuario no encontrado");
            }
            tool.setUser(userOpt.get());

            Tools saved = toolsService.save(tool);
            return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(saved);
        } catch (IOException e) {
            return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Error al procesar la imagen: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tools tool, @PathVariable Long id) {
        return toolsService.update(id, tool)
            .map(updated -> ResponseEntity.status(HttpStatus.CREATED).body(updated))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return toolsService.delete(id)
            .map(deleted -> ResponseEntity.ok(deleted))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
@GetMapping("/proveedor/{userId}")
public ResponseEntity<Map<String, Object>> getToolsByProveedor(@PathVariable Long userId) {
    Map<String, Object> response = new HashMap<>();

    try {
        // Obtiene directamente los DTOs desde el servicio
        List<ToolRequestDTO2> herramientas = toolsService.getToolsByProveedor(userId);

        if (herramientas.isEmpty()) {
            response.put("error", "No se encontraron herramientas para el usuario.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("tools", herramientas);
        return ResponseEntity.ok(response);

    } catch (Exception e) {
        response.put("error", "Error interno del servidor: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}



}

