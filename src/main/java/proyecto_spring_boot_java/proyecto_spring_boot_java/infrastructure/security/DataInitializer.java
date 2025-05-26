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
                System.out.println("Usuario administrador creado por defecto.");
            } else {
                System.out.println("Usuario administrador ya existe.");
            }

            String defaultClienteUsername = "cliente@gmail.com";
            if (userRepository.findByUsername(defaultClienteUsername).isEmpty()) {
                User cliente = new User();
                cliente.setUsername(defaultClienteUsername);
                cliente.setPassword(passwordEncoder.encode("cliente1"));
                cliente.setName("Cliente Predeterminado");
                cliente.setTelefono("0000000002");
                cliente.setRole(Role.ROLE_CUSTOMER);
                userRepository.save(cliente);
                System.out.println("Usuario cliente creado por defecto.");
            } else {
                System.out.println("Usuario cliente ya existe.");
            }

          
            String defaultProveedorUsername = "proveedor@gmail.com";
            if (userRepository.findByUsername(defaultProveedorUsername).isEmpty()) {
                User proveedor = new User();
                proveedor.setUsername(defaultProveedorUsername);
                proveedor.setPassword(passwordEncoder.encode("proveedor1"));
                proveedor.setName("Proveedor Predeterminado");
                proveedor.setTelefono("0000000003");
                proveedor.setRole(Role.ROLE_SUPPLIER);
                userRepository.save(proveedor);
                System.out.println("Usuario proveedor creado por defecto.");
            } else {
                System.out.println("Usuario proveedor ya existe.");
            }
        };
    }
}