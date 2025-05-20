package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Return;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Return;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IReturnService;

@Service
public class ReturnImpl implements IReturnService {
    private ReturnRepository repository;

    public ReturnImpl(ReturnRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Return> findAll() {
        return (List<Return>) repository.findAll();
    }

    @Override
    public Optional<Return> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Return save(Return returnObj) {
        return repository.save(returnObj);
    }

    @Override
    public Optional<Return> update(Long id, Return returnObj) {
        Optional<Return> existing = repository.findById(id);
        if (existing.isPresent()) {
            Return dbReturn = existing.get();
            dbReturn.setDescription(returnObj.getDescription());
            return Optional.of(repository.save(dbReturn));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Return> delete(Long id) {
        Optional<Return> returnOptional = repository.findById(id);
        returnOptional.ifPresent(r -> repository.deleteById(id));
        return returnOptional;
    }
}