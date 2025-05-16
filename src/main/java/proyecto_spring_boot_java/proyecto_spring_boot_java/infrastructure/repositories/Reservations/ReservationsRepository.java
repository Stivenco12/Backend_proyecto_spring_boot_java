package proyecto_spring_boot_java.proyecto_spring_boot_java.infrastructure.repositories.Reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto_spring_boot_java.proyecto_spring_boot_java.Domain.entities.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {

}
