package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
