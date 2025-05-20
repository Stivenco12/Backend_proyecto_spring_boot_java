package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.User;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.dto.SaveUser;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IUserService;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.models.exception.InvalidPasswordException;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registrOneCustomer(SaveUser newUser) {
        validatePassword(newUser);
        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());
        user.setTelefono(newUser.getTelefono());
        user.setRole(Role.ROLE_CUSTOMER);
        System.out.println("Guardando usuario: " + user.getUsername());
        return userRepository.save(user);   
    } 

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveUser dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }
    }
    @Override
    public User registrOneSupplier(SaveUser newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setUsername(newUser.getUsername());
        user.setTelefono(newUser.getTelefono());
        user.setPassword(passwordEncoder.encode(newUser.getPassword())); 
        user.setRole(Role.ROLE_SUPPLIER);
        return userRepository.save(user);
    }

    @Override
    public User registrOneAdmin(SaveUser newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setUsername(newUser.getUsername());
        user.setTelefono(newUser.getTelefono());
        user.setPassword(passwordEncoder.encode(newUser.getPassword())); 
        user.setRole(Role.ROLE_ADMINISTRATOR);
        return userRepository.save(user);
    }
}
