package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Category_tool;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category_tool;

@Repository
public interface Category_toolRepository extends JpaRepository<Category_tool, Long> {

}
