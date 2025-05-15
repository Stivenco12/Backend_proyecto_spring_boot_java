package proyecto_spring_boot_java.proyecto_spring_boot_java.application.services;

import java.util.List;
import java.util.Optional;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Reservations;

public interface IReservationsService {
    List<Reservations> findAll();
    Optional<Reservations> findById(Long id);
    Reservations save(Reservations reservations);
    Optional<Reservations> update(Long id, Reservations reservations);
    Optional<Reservations> delete(Long id);
}
