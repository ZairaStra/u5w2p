package zairastra.u5w2p.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zairastra.u5w2p.entities.BusinessTrip;

import java.time.LocalDate;
import java.util.Optional;

public interface BusinessTripsRepository extends JpaRepository<BusinessTrip, Long> {
    //per verificare di non salvare due volte un viaggio per lo stesso giorno nello stesso posto
    Optional<BusinessTrip> findByTravelDateAndDestination(LocalDate travelDate, String destination);
}
