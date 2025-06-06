package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;

public interface IUserService {
    Optional<User> findById(Long id);
    User registrOneCustomer(SaveUser newUser);
    User registrOneSupplier(SaveUser newUser);
    User registrOneAdmin(SaveUser newUser);
    Optional<User> findOneByUsername(String username);
    List<User> getAllUsers();
}