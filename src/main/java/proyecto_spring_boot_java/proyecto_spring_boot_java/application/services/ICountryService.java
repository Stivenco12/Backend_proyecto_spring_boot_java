package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Country;

public interface ICountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    Optional<Country> update(Long id, Country country);
    Optional<Country> delete(Long id);   
} 
