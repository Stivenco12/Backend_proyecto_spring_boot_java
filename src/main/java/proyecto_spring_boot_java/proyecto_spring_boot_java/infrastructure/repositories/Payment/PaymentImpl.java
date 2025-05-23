package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Payment;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IPaymentService;

@Service
public class PaymentImpl implements IPaymentService {
    private final PaymentRepository repository;

    public PaymentImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment> update(Long id, Payment payment) {
        Optional<Payment> paymentOld = repository.findById(id);
        if (paymentOld.isPresent()) {
            Payment paymentDb = paymentOld.get();
            paymentDb.setPaymentTypeId(payment.getPaymentTypeId()); // Asegúrate de que Payment tenga este setter
            return Optional.of(repository.save(paymentDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Payment> delete(Long id) {
        Optional<Payment> payment = repository.findById(id);
        if (payment.isPresent()) {
            repository.deleteById(id);
            return payment;
        }
        return Optional.empty();
    }
}