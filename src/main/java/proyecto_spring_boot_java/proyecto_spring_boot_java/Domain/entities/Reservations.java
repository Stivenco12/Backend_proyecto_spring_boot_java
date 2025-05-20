package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Tools_id")
    @JsonBackReference
    private Tools toolsId;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    @JsonBackReference
    private Customer customerId;

    @Embedded
    Audit audit = new Audit();

    @OneToOne
    @JoinColumn(name = "Payment_id")
    @JsonBackReference
    private Payment paymentId;
}