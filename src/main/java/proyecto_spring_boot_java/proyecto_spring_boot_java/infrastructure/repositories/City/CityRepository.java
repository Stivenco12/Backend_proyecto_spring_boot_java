package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.City;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {
}