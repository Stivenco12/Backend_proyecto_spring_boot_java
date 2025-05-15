package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category_tool;

public interface ICategory_tool {
    List<Category_tool> findAll();
    Optional<Category_tool> findById(Long id);
    Category_tool save(Category_tool categoryTool);
    Optional<Category_tool> update(Long id, Category_tool categoryTool);
    Optional<Category_tool> delete(Long id);
}
