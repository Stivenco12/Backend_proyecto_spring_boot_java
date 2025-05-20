package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

    @Column(length = 50, nullable = true)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "Supplier_id")
    @JsonBackReference
    private Supplier supplierId;

    @Embedded
    Audit audit = new Audit();

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private CategoryType category;


    @Column(nullable = false)
    private Integer disponibilidad;

    @Column(nullable = false)
    private Double costoDiario;

    @Column(length = 255)
    private String descripcion;

    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
}
