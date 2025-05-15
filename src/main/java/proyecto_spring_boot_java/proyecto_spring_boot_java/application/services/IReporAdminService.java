package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Report_admin;

public interface IReporAdminService {
    List<Report_admin> findAll();
    Optional<Report_admin> findById(Long id);
    Report_admin save(Report_admin Report_admin);
    Optional<Report_admin> update(Long id, Report_admin Report_admin);
    Optional<Report_admin> delete(Long id);
}
