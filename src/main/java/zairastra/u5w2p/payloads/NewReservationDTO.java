package zairastra.u5w2p.payloads;

import jakarta.validation.constraints.NotNull;
import zairastra.u5w2p.entities.BusinessTrip;
import zairastra.u5w2p.entities.Employee;

import java.time.LocalDate;

public record NewReservationDTO(
        @NotNull(message = "Request date is required")
        LocalDate requestDate,
        String optionalPreference,
        @NotNull(message = "Employee ID is required")
        Employee employee,
        @NotNull(message = "BusinessTrip ID is required")
        BusinessTrip businessTrip) {
}
