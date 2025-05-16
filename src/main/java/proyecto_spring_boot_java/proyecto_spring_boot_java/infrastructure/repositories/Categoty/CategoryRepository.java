package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Categoty;

import org.springframework.data.jpa.repository.JpaRepository;

import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
