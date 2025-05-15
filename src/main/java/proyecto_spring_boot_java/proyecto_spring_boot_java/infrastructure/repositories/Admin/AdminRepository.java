package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
