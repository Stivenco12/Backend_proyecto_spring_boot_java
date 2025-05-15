package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByName(String name); 
}