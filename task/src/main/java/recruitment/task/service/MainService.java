package recruitment.task.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recruitment.task.dto.FlightNumberRequestDto;
import recruitment.task.dto.FlightNumberResponseDto;
import recruitment.task.dto.IATACodeRequestDto;
import recruitment.task.dto.IATACodeResponseDto;
import recruitment.task.exception.FlightNotFound;
import recruitment.task.model.Baggage;
import recruitment.task.model.Cargo;
import recruitment.task.model.CargoEntity;
import recruitment.task.model.FlightEntity;
import recruitment.task.repository.CargoEntityRepository;
import recruitment.task.repository.FlightEntityRepository;

import java.util.List;

@Service
public class MainService {


    @Autowired
    private CargoEntityRepository cargoEntityRepository;
    @Autowired
    private FlightEntityRepository flightEntityRepository;

    public FlightNumberResponseDto flightRequest(FlightNumberRequestDto flightNumberRequestDto){
        CargoEntity cargoEntity = cargoEntityRepository
                .findCargoEntityByFlightId(flightNumberRequestDto.getFlightId())
                .orElseThrow(FlightNotFound::new);

        double cargoWeight = cargoEntity.getCargo().stream().mapToDouble(Cargo::getWeightInKg).sum();
        double baggageWeight = cargoEntity.getBaggage().stream().mapToDouble(Baggage::getWeightInKg).sum();

        return FlightNumberResponseDto.builder()
                .baggageWeight(baggageWeight)
                .cargoWeight(cargoWeight)
                .totalWeight(baggageWeight+cargoWeight)
                .build();
    }


    public IATACodeResponseDto codeRequest(IATACodeRequestDto iataCodeRequestDto){
        var arrivingFlights =  flightEntityRepository
                .findFlightEntitiesByArrivalAirportIATACode(iataCodeRequestDto.getIATACode());
        var departingFlights = flightEntityRepository
                .findFlightEntitiesByDepartureAirportIATACode(iataCodeRequestDto.getIATACode());
        int arrivingBaggages = getNumOfBaggage(arrivingFlights);
        int departingBaggages = getNumOfBaggage(departingFlights);
        return IATACodeResponseDto.builder()
                .arrivingFlights(arrivingFlights.size())
                .arrivingBaggage(arrivingBaggages)
                .departingBaggage(departingBaggages)
                .departingFlights(departingFlights.size())
                .build()
                ;
    }

    private int getNumOfBaggage(List<FlightEntity> flightEntities){
        return flightEntities.stream()
                .map(flightEntity ->
                                cargoEntityRepository.findCargoEntityByFlightId(flightEntity.getFlightId())
                                .get().getBaggage().stream()
                                .map(Baggage::getPieces).mapToInt(Integer::intValue).sum()
                )
                .mapToInt(Integer::intValue).sum();

    }
}
