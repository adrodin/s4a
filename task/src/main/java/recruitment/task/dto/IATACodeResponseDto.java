package recruitment.task.dto;


import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IATACodeResponseDto {
    private int departingFlights;
    private int arrivingFlights;
    private int arrivingBaggage;
    private int departingBaggage;
}
