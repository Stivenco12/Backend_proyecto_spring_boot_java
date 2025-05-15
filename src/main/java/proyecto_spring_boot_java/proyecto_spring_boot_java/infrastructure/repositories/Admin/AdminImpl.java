package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Admin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Admin;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IAdminService;

@Service
public class AdminImpl implements IAdminService {
    @Autowired
    private IAdminService repository;

    @Transactional(readOnly = true)
    @Override
    public List<Admin> findAll() {
        return (List<Admin>) repository.findAll();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Admin save(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public Optional<Admin> update(Long id, Admin admin) {
        Optional<Admin> adminOld = repository.findById(id);
        if(adminOld.isPresent()){
            Admin adminDb = adminOld.orElseThrow();
            adminDb.setReportAdminId(admin.getReportAdminId());
            return Optional.of(repository.save(adminDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Admin> delete(Long id) {
        Optional<Admin> adminOptional = repository.findById(id);
        adminOptional.ifPresent(admintDb -> {
            repository.delete(admintDb.getId());
        });
        return adminOptional;        
    }
    
}
