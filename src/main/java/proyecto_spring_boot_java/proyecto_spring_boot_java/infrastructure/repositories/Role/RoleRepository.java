package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
