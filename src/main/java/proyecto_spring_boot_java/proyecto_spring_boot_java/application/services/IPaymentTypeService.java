package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment_type;

public interface IPaymentTypeService {
    List<Payment_type> findAll();
    Optional<Payment_type> findById(Long id);
    Payment_type save(Payment_type Payment_type);
    Optional<Payment_type> update(Long id, Payment_type Payment_type);
    Optional<Payment_type> delete(Long id);
}
