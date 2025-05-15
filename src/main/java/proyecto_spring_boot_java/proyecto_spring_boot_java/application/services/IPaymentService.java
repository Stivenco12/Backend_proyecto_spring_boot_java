package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment;

public interface IPaymentService {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    Payment save(Payment payment);
    Optional<Payment> update(Long id, Payment payment);
    Optional<Payment> delete(Long id);
}
