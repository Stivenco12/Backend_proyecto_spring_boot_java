package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @OneToOne(mappedBy = "paymentId")
@JsonManagedReference("payment-reservation")
private Reservations reservation;

@ManyToOne
@JoinColumn(name = "payment_type_id")
@JsonBackReference("paymenttype-payment")
private Payment_type paymentTypeId;
@Embedded
Audit audit = new Audit();
}
