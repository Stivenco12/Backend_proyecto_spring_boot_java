package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToolRequestDTO {
    private String name;
    private String descripcion;
    private String category;
    private Integer disponibilidad;
    private Double costoDiario;
    private Long userId;  
    private byte[] datosImagen;
}