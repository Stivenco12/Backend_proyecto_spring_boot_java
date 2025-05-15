package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
