package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto;

import lombok.Getter;
import lombok.Setter;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.CategoryType;

@Getter
@Setter
public class ToolRequestDTO2 {
  private String name;
    private String descripcion;
    private String category;
    private Integer disponibilidad;
    private Double costoDiario;
    private Long userId;
    public ToolRequestDTO2(String name, String descripcion, CategoryType category, Integer disponibilidad, Double costoDiario,
            Long userId) {
        this.name = name;
        this.descripcion = descripcion;
        this.category = (category != null) ? category.toString() : "Sin categoría";
        this.disponibilidad = disponibilidad;
        this.costoDiario = costoDiario;
        this.userId = userId;
    } 


    
}
