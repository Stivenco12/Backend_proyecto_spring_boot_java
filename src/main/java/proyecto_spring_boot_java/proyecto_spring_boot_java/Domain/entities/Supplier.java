package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 50, nullable = true)
    private String Tipo_de_Proveedor;

    @Column(length = 50, nullable = true)
    private String Cantidad_de_Ventas;

    @Column(length = 50, nullable = true)
    private String Cantidad_de_Productos;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User userId;

    @Embedded
    Audit audit = new Audit();

    @OneToMany(mappedBy = "supplierId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Tools> tools = new HashSet<>();
}
