package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Categoty;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveCategory;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Category;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOne(SaveCategory saveCategory) {

        Category category = new Category();
        category.setName(saveCategory.getName());
        category.setStatus(Category.CategoryStatus.ENABLED);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneById'");
    }

    @Override
    public Category disableOneById(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disableOneById'");
    }



}
