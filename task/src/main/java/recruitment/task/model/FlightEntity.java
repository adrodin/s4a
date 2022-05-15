package recruitment.task.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("flights")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightEntity {

    @JsonIgnore
    @Id
    private String _id;

    private int flightId;
    private int flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private LocalDateTime departureDate;
}
