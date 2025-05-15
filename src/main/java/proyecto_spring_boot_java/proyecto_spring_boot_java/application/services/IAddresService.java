package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Address;

public interface IAddresService {
    List<Address> findAll();
    Optional<Address> findById(Long id);
    Address save(Address address);
    Optional<Address> update(Long id, Address address);
    Optional<Address> delete(Long id);
}
