package recruitment.task.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class IATACodeRequestDto {

    @NotBlank
    private String IATACode;
    @DateTimeFormat(fallbackPatterns = "YYYY-MM-ddThh:mm:ss")
    private LocalDateTime date;
}
