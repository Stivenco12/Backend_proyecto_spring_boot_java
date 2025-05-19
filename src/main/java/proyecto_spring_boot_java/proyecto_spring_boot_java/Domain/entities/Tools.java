package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @Column(length = 50, nullable = true)
    private String name;

    @Lob
    @Column(name = "datos_imagen", nullable = false)
    private byte[] datosImagen;

    @Column(length = 50, nullable = true)
    private String brand;

    @Column(length = 50, nullable = true)
    private int stock;

    @Column(length = 50, nullable = true)
    private String costo_diario;

    
    @Column(length = 50, nullable = true)
    private String estado;


    @Column(length = 50, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "Supplier_id")
    @JsonBackReference
    private Supplier supplierId;

    @Embedded
    Audit audit = new Audit();

    @OneToOne
    private Category_tool Category_tool;
}
