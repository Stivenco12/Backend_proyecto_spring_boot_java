package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Return;

public interface IReturnService {
    List<Return> findAll();
    Optional<Return> findById(Long id);
    Return save(Return Return);
    Optional<Return> update(Long id, Return Return);
    Optional<Return> delete(Long id);
}
