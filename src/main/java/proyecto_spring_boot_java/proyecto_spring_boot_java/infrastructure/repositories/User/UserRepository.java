package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.User;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
   
} 