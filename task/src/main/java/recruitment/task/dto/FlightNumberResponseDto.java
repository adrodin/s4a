package recruitment.task.dto;


import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightNumberResponseDto {
    private double cargoWeight;
    private double baggageWeight;
    private double totalWeight;
}
