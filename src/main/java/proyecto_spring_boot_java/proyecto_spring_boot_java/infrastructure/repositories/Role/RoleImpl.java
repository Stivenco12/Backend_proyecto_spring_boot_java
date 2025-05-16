package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Role;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Role;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IRoleService;

@Service
public class RoleImpl implements IRoleService {

    private RoleRepository repository;

    public RoleImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) repository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> update(Long id, Role role) {
        Optional<Role> existing = repository.findById(id);
        if (existing.isPresent()) {
            Role dbRole = existing.get();
            dbRole.setName_Role(role.getName_Role());
            return Optional.of(repository.save(dbRole));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Role> delete(Long id) {
        Optional<Role> roleOptional = repository.findById(id);
        roleOptional.ifPresent(r -> repository.deleteById(id));
        return roleOptional;
    }
}
