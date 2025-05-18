package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveCategory;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category;
import java.util.Optional;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findOneById(Long categoryId);

    Category createOne(SaveCategory saveCategory);

    Category updateOneById(Long categoryId, SaveCategory saveCategory);

    Category disableOneById(Long categoryId);
}
