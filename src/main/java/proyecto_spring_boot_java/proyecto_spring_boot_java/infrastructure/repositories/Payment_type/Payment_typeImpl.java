package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Payment_type;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Payment_type;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IPaymentTypeService;

@Service
public class Payment_typeImpl implements IPaymentTypeService {

    private Payment_typeRepository repository;

    public Payment_typeImpl(Payment_typeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment_type> findAll() {
        return (List<Payment_type>) repository.findAll();
    }

    @Override
    public Optional<Payment_type> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Payment_type save(Payment_type payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<Payment_type> update(Long id, Payment_type payment) {
        Optional<Payment_type> existingPayment = repository.findById(id);
        if (existingPayment.isPresent()) {
            Payment_type paymentDb = existingPayment.get();
            paymentDb.setType(payment.getType()); 
            return Optional.of(repository.save(paymentDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Payment_type> delete(Long id) {
        Optional<Payment_type> paymentOptional = repository.findById(id);
        paymentOptional.ifPresent(payment -> {
            repository.deleteById(id);
        });
        return paymentOptional;
    }

}

