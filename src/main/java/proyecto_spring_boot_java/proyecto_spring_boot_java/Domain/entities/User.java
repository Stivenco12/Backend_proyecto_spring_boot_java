package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = true)
    private String name;

    @Column(length = 50, nullable = true)
    private String email;

    @Column(length = 50, nullable = true)
    private String phone;

    @Column(length = 50, nullable = true)
    private String password;

    @Embedded
    Audit audit = new Audit();

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private java.util.List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "City_id")
    @JsonBackReference
    private City cityId;
}
