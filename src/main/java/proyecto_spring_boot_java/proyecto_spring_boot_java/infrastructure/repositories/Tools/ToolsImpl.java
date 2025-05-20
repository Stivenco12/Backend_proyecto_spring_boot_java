package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Tools;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Tools;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IToolsService;

@Service
public class ToolsImpl implements IToolsService {
    private ToolsRepository repository;

    public ToolsImpl(ToolsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tools> findAll() {
        return (List<Tools>) repository.findAll();
    }

    @Override
    public Optional<Tools> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Tools save(Tools tool) {
        return repository.save(tool);
    }

    @Override
    public Optional<Tools> update(Long id, Tools tool) {
        Optional<Tools> existing = repository.findById(id);
        if (existing.isPresent()) {
            Tools dbTool = existing.get();
            dbTool.setName(tool.getName());
            dbTool.setCategory(tool.getCategory());
            dbTool.setDisponibilidad(tool.getDisponibilidad());
            dbTool.setCostoDiario(tool.getCostoDiario());
            dbTool.setDescripcion(tool.getDescripcion());
            if (tool.getImagen() != null && tool.getImagen().length > 0) {
                dbTool.setImagen(tool.getImagen());
            }
            return Optional.of(repository.save(dbTool));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Tools> delete(Long id) {
        Optional<Tools> toolOptional = repository.findById(id);
        toolOptional.ifPresent(t -> repository.deleteById(id));
        return toolOptional;
    }
}