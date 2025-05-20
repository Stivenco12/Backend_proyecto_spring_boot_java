package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Tools;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Tools;

public interface ToolsRepository extends JpaRepository<Tools, Long> {
}