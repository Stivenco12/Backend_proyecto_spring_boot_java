package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    Optional<User> update(Long id, User user);
    Optional<User> delete(Long id);
}
