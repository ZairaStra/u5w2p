package zairastra.u5w2p.payloads;

import java.time.LocalDateTime;
import java.util.List;

//mi da gli errori in italiano?????
public record ErrorsWithListDTO(String message, LocalDateTime stamp, List<String> errorsList) {
}
