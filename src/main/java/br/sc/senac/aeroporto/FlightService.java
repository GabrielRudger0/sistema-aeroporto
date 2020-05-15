package br.sc.senac.aeroporto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/flight")

public class FlightService {

	private final FlightController flightController;

	public FlightService(final FlightController flightController) {
		this.flightController = flightController;
	}

	@GetMapping("/registerinflight/passenger/{flightId}/{passengerId}")
	public ResponseEntity<FlightDTO> registerPassenger(@PathVariable Long flightId, @PathVariable Long passengerId) {
		FlightDTO flight = this.flightController.registerPassengerOnAFlight(flightId, passengerId);
		if (flight == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(flight, HttpStatus.OK);
	}

}
