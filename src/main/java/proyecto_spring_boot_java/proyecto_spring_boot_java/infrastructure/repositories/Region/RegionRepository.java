package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
