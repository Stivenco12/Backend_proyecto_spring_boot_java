package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
