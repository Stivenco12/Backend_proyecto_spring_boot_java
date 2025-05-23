package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Payment_types")
public class Payment_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = true)
    private String type;

    @OneToMany(mappedBy = "paymentTypeId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JsonManagedReference("paymenttype-payment")
    private Set<Payment> payments = new HashSet<>();

    @Embedded
    Audit audit = new Audit();

}
