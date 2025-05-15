package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Damage_report;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Damage_report;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IDamage_reportService;

@Service
public class Damage_reportImpl implements IDamage_reportService {

    private final Damage_reportRepository damageReportRepository;

    public Damage_reportImpl(Damage_reportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    @Override
    public List<Damage_report> findAll() {
        return damageReportRepository.findAll();
    }

    @Override
    public Optional<Damage_report> findById(Long id) {
        return damageReportRepository.findById(id);
    }

    @Override
    public Damage_report save(Damage_report damageReport) {
        return damageReportRepository.save(damageReport);
    }

    @Override
    public Optional<Damage_report> update(Long id, Damage_report damageReport) {
        if (damageReportRepository.existsById(id)) {
            damageReport.setId(id);
            return Optional.of(damageReportRepository.save(damageReport));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Damage_report> delete(Long id) {
        if (damageReportRepository.existsById(id)) {
            Optional<Damage_report> damageReport = damageReportRepository.findById(id);
            damageReportRepository.deleteById(id);
            return damageReport;
        }
        return Optional.empty();
    }
}
