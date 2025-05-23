package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.User;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.utils.Role;
import proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.User.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String defaultAdminUsername = "admin@gmail.com";
            if (userRepository.findByUsername(defaultAdminUsername).isEmpty()) {
                User admin = new User();
                admin.setUsername(defaultAdminUsername);
                admin.setPassword(passwordEncoder.encode("admin123")); 
                admin.setName("Administrador");
                admin.setTelefono("0000000001");
                admin.setRole(Role.ROLE_ADMINISTRATOR); 

                userRepository.save(admin);
                System.out.println("usuario administrador creado por defecto.");
            } else {
                System.out.println("usuario administrador ya existe.");
            }
        };
    }
}
