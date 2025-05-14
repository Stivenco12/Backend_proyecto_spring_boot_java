package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private Date fechaPago;

    @Column(nullable = false, length = 50)
    private String metodoPago;




}
