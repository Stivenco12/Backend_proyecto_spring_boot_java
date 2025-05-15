package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.City;

public interface ICityService {
    List<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    Optional<City> update(Long id, City city);
    Optional<City> delete(Long id);
}
