package zairastra.u5w2p.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message, LocalDateTime stamp, List<String> errorsList) {
}
