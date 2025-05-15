package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Customer;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Customer;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.ICustomerService;

@Service
public class CustomerImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>)  customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> update(Long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return Optional.of(customerRepository.save(customer));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Customer> delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.ifPresent(customerDb -> {
            customerRepository.delete(customerDb);
        });
        return customerOptional;
    }
}
