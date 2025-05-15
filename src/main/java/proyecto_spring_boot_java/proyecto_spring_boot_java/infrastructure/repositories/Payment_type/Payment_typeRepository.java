package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Payment_type;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment_type;

public interface Payment_typeRepository extends JpaRepository<Payment_type, Long> {
    
}
