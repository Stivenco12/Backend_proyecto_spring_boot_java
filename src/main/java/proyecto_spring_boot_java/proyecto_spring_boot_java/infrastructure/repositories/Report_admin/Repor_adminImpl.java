package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Report_admin;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Report_admin;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IReporAdminService;

@Service
public class Repor_adminImpl implements IReporAdminService {

    private Repor_adminRepository repository;

    public Repor_adminImpl(Repor_adminRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Report_admin> findAll() {
        return (List<Report_admin>) repository.findAll();
    }

    @Override
    public Optional<Report_admin> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Report_admin save(Report_admin reportAdmin) {
        return repository.save(reportAdmin);
    }

    @Override
    public Optional<Report_admin> update(Long id, Report_admin reportAdmin) {
        Optional<Report_admin> existing = repository.findById(id);
        if (existing.isPresent()) {
            Report_admin dbReport = existing.get();
            dbReport.setDescription(reportAdmin.getDescription()); 
            return Optional.of(repository.save(dbReport));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Report_admin> delete(Long id) {
        Optional<Report_admin> reportAdmin = repository.findById(id);
        reportAdmin.ifPresent(r -> repository.deleteById(id));
        return reportAdmin;
    }
}
