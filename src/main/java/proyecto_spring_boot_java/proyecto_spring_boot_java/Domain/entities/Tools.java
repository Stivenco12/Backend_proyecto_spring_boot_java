package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Setter
@Getter
@Entity
@Table(name = "tools")
public class Tools {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, nullable = false)
  private String name;

  @Lob
  @Column(name = "datos_imagen", nullable = true)
  @JsonIgnore
  private byte[] datosImagen;

  public String getImagenBase64() {
    return datosImagen != null ? Base64.getEncoder().encodeToString(datosImagen) : null;
  }

  @Column
  private int stock;

  @Column(length = 255)
  private String descripcion;

    @Embedded
    Audit audit = new Audit();

  @Column(nullable = false)
  private Integer disponibilidad;

  @Column(nullable = false)
  private Double costoDiario;

   

    // Cambiado de Supplier a User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}
