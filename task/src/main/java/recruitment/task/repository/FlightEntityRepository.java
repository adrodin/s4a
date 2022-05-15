package recruitment.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import recruitment.task.model.FlightEntity;
import java.util.List;


public interface FlightEntityRepository extends MongoRepository<FlightEntity, String> {

    public List<FlightEntity> findFlightEntitiesByArrivalAirportIATACode(String code);
    public List<FlightEntity> findFlightEntitiesByDepartureAirportIATACode(String code);
}
