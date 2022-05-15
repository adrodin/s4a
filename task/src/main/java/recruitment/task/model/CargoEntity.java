package recruitment.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document("cargo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CargoEntity {

    @Id
    @JsonIgnore
    private String _id;

    private int flightId;
    private List<Cargo> cargo;
    private List<Baggage> baggage;

}
