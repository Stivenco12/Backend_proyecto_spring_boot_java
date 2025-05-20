package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Supplier;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Supplier;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ISupplierService;

@Service
public class SupplierImpl implements ISupplierService {
    private SupplierRepository repository;

    public SupplierImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) repository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Optional<Supplier> update(Long id, Supplier supplier) {
        Optional<Supplier> existing = repository.findById(id);
        if (existing.isPresent()) {
            Supplier dbSupplier = existing.get();
            dbSupplier.setCantidad_de_Productos(supplier.getCantidad_de_Productos());
            dbSupplier.setCantidad_de_Ventas(supplier.getCantidad_de_Ventas());
            return Optional.of(repository.save(dbSupplier));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Supplier> delete(Long id) {
        Optional<Supplier> supplierOptional = repository.findById(id);
        supplierOptional.ifPresent(s -> repository.deleteById(id));
        return supplierOptional;
    }
}