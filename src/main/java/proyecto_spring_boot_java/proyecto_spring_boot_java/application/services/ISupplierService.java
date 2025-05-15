package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Supplier;

public interface ISupplierService {
    List<Supplier> findAll();
    Optional<Supplier> findById(Long id);
    Supplier save(Supplier supplier);
    Optional<Supplier> update(Long id, Supplier supplier);
    Optional<Supplier> delete(Long id);
}
