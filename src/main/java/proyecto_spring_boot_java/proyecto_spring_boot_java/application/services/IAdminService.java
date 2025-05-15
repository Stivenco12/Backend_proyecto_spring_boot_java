package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Admin;

public interface IAdminService {
    List<Admin> findAll();
    Optional<Admin> findById(Long id);
    Admin save(Admin admin);
    Optional<Admin> update(Long id, Admin admin);
    Optional<Admin> delete(Long id);
}
