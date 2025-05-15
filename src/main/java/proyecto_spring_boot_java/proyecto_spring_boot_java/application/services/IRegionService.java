package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Region;

public interface IRegionService {
    List<Region> findAll();
    Optional<Region> findById(Long id);
    Region save(Region region);
    Optional<Region> update(Long id, Region region);
    Optional<Region> delete(Long id);
} 
