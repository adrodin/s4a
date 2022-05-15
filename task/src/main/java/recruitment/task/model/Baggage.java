package recruitment.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Baggage {

    @Id
    @JsonIgnore
    private String _id;

    private Long id;
    private double weight;
    private String weightUnit;
    private int pieces;

    public double getWeightInKg(){
        if(weightUnit.equals("lb")){
            return weight*0.45359237;
        }else{
            return weight;
        }
    }
}

