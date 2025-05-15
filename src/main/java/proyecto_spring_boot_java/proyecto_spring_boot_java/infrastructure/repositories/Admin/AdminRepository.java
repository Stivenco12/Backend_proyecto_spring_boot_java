package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
