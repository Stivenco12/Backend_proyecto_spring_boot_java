package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Customer;

public interface ICustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    Optional<Customer> update(Long id, Customer customer);
    Optional<Customer> delete(Long id);
}
