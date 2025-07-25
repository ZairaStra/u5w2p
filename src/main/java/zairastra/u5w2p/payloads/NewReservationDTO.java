package zairastra.u5w2p.payloads;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewReservationDTO(
        @NotNull(message = "Request date is required")
        LocalDate requestDate,
        String optionalPreference,
        @NotNull(message = "Employee ID is required")
        Long employeeId,
        @NotNull(message = "BusinessTrip ID is required")
        Long businessTripId) {
}
