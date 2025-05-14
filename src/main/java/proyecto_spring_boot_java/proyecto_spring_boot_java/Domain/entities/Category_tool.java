package proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Category_tools")
public class Category_tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = true)
    private String type;

    @Column(length = 50, nullable = true)
    private String description;
    
    @Column(length = 50, nullable = true)
    private String image;

    @Embedded
    Audit audit = new Audit();
}
