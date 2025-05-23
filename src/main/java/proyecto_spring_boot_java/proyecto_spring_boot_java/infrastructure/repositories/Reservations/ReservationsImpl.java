package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Reservations;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Reservations;
import proyecto_spring_boot_java.proyecto_spring_boot_java.application.services.IReservationsService;

@Service
public class ReservationsImpl implements IReservationsService {
    private ReservationsRepository repository;

    public ReservationsImpl(ReservationsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Reservations> findAll() {
        return (List<Reservations>) repository.findAll();
    }

    @Override
    public Optional<Reservations> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Reservations save(Reservations reservations) {
        return repository.save(reservations);
    }

    @Override
    public Optional<Reservations> update(Long id, Reservations reservations) {
        Optional<Reservations> existing = repository.findById(id);
        if (existing.isPresent()) {
            Reservations dbReservation = existing.get();
            dbReservation.setUserId(reservations.getUserId());
            return Optional.of(repository.save(dbReservation));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Reservations> delete(Long id) {
        Optional<Reservations> reservations = repository.findById(id);
        reservations.ifPresent(r -> repository.deleteById(id));
        return reservations;
    }
    
}