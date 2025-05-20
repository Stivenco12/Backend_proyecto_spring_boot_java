package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Damage_report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Damage_report;

@Repository
public interface Damage_reportRepository extends JpaRepository<Damage_report, Long> {
}