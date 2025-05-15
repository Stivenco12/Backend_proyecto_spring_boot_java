package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Damage_report;

public interface IDamage_reportService {
    List<Damage_report> findAll();
    Optional<Damage_report> findById(Long id);
    Damage_report save(Damage_report damage_report);
    Optional<Damage_report> update(Long id, Damage_report damage_report);
    Optional<Damage_report> delete(Long id);
}
