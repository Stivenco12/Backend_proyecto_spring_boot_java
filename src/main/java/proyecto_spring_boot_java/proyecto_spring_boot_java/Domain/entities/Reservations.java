package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import java.time.LocalDate;

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
@Table(name = "Reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Tools_id")
    
    private Tools toolsId;

    @ManyToOne
    @JoinColumn(name = "User_id")
    @JsonBackReference("user-reservation")
   private User user;

    @Embedded
    Audit audit = new Audit();

    @OneToOne
    @JoinColumn(name = "Payment_id")
    @JsonBackReference("payment-reservation")
    private Payment paymentId;

    @Column(length = 250, nullable = true)
    private String facturas;

    @Lob
    @Column(name = "factura_pdf")
    private byte[] facturaPdf;

     @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;
}