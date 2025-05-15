package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Tools;

public interface IToolsService {
    List<Tools> findAll();
    Optional<Tools> findById(Long id);
    Tools save(Tools Tools);
    Optional<Tools> update(Long id, Tools Tools);
    Optional<Tools> delete(Long id);
}
