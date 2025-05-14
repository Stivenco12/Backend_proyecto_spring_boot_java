package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Returns")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = true)
    private String description;

    @OneToOne
    @JoinColumn(name = "Damage_report_id")
    @JsonBackReference
    private Damage_report damageReportId;

    @OneToOne
    @JoinColumn(name = "Reservation_id")
    @JsonBackReference
    private Reservations reservationsId;

    @Embedded
    Audit audit = new Audit();
}
