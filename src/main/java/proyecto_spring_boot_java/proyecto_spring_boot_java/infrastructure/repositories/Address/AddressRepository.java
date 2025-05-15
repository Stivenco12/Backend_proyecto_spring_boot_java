package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    boolean existsByName(String name); 
} 