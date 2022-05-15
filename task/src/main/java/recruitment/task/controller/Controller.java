package recruitment.task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recruitment.task.dto.FlightNumberRequestDto;
import recruitment.task.dto.IATACodeRequestDto;
import recruitment.task.service.MainService;

import javax.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private MainService mainService;

    @GetMapping("/api/ex1")
    public ResponseEntity<?> flightRequest(@RequestBody @Valid FlightNumberRequestDto flightNumberRequest){
        return ResponseEntity.status(HttpStatus.OK).body(mainService.flightRequest(flightNumberRequest));
    }

    @GetMapping("api/ex2")
    public ResponseEntity<?> codeRequest(@RequestBody @Valid IATACodeRequestDto iataCodeRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(mainService.codeRequest(iataCodeRequestDto));
    }

}
