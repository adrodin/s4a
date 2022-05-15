package recruitment.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import recruitment.task.model.CargoEntity;

import java.util.Optional;

public interface CargoEntityRepository extends MongoRepository<CargoEntity, String> {

    public Optional<CargoEntity> findCargoEntityByFlightId(int id);
}
