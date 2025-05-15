package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
