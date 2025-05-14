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
@Table(name = "Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User userId;

    @ManyToOne
    @JoinColumn(name = "Report_admin_id")
    @JsonBackReference
    private Report_admin reportAdminId;

    @ManyToOne
    @JoinColumn(name = "Invoces_admin_id")
    @JsonBackReference
    private Invoices_admin invocesAdminId;

    @Embedded
    Audit audit = new Audit();
}
