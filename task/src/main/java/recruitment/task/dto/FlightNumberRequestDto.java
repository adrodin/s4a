package recruitment.task.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FlightNumberRequestDto {

    @NotNull
    private int flightId;
    @DateTimeFormat(fallbackPatterns = "YYYY-MM-ddThh:mm:ss")
    private LocalDateTime date;
}
