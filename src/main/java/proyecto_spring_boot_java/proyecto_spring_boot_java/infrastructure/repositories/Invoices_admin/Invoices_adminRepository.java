package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Invoices_admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Invoices_admin;

@Repository
public interface Invoices_adminRepository extends JpaRepository<Invoices_admin, Long> {
    
}
