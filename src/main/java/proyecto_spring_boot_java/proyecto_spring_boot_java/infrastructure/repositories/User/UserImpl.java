package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.User;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IUserService;

@Service
public class UserImpl implements IUserService {

    private UserRepository repository;

    public UserImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> update(Long id, User user) {
        Optional<User> existing = repository.findById(id);
        if (existing.isPresent()) {
            User dbUser = existing.get();
            dbUser.setName(user.getName());
            dbUser.setEmail(user.getEmail());
            dbUser.setPassword(user.getPassword());
            dbUser.setPhone(user.getPhone());
            return Optional.of(repository.save(dbUser));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(Long id) {
        Optional<User> userOptional = repository.findById(id);
        userOptional.ifPresent(u -> repository.deleteById(id));
        return userOptional;
    }
}
