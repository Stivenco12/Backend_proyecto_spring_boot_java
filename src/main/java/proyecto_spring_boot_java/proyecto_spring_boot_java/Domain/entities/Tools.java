package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @Column(name = "datos_imagen", nullable = false)
    private byte[] datosImagen;

    public String getImagenBase64() {
    return datosImagen != null ? java.util.Base64.getEncoder().encodeToString(datosImagen) : null;
}

    @Column(length = 50)
    private String brand;

    @Column
    private int stock;

    @Column(length = 255)
    private String descripcion;

    @Embedded
    Audit audit = new Audit();

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private CategoryType category;

    @Column(nullable = false)
    private Integer disponibilidad;

    @Column(nullable = false)
    private Double costoDiario;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference("user-tools")
    private User user;

    @OneToMany(mappedBy = "toolsId")
@JsonManagedReference("tools-reservation")
private List<Reservations> reservations;
}
