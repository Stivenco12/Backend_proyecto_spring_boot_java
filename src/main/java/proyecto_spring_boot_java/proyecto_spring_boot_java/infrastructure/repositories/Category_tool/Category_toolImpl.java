package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Category_tool;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category_tool;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ICategory_toolService;

@Service
public class Category_toolImpl implements ICategory_toolService {
    @Autowired
    private Category_toolRepository repository;

    @Override
    public List<Category_tool> findAll() {
        return (List<Category_tool>) repository.findAll();
    }

    @Override
    public Optional<Category_tool> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category_tool save(Category_tool category_tool) {
        return repository.save(category_tool);
    }

    @Override
    public Optional<Category_tool> update(Long id, Category_tool category_tool) {
        Optional<Category_tool> category_toolOld = repository.findById(id);
        if(category_toolOld.isPresent()){
            Category_tool category_toolDb = category_toolOld.orElseThrow();
            category_toolDb.setType(category_tool.getType());
            category_toolDb.setDatosImagen(category_tool.getDatosImagen());
            return Optional.of(repository.save(category_toolDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Category_tool> delete(Long id) {
        Optional<Category_tool> category_toolOptional = repository.findById(id);
        category_toolOptional.ifPresent(categoryToolDb -> {
            repository.delete(categoryToolDb);
        });
        return category_toolOptional;        
    }
    
}
