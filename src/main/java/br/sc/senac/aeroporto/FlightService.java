package br.sc.senac.aeroporto;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/flight")
public class FlightService {
	
	private static FlightEntity EntidadeFlight = new FlightEntity();

	private static FlightDTO[] DEFAULT_FLIGHTS = new FlightDTO[] {
			new FlightDTO(Long.valueOf(0), "British Airways", "22/12/2020", "03/01/2021", "London, UK", EntidadeFlight.getPassengers()),
			new FlightDTO(Long.valueOf(0), "TAM", "23/12/2020", "04/01/2021", "São Paulo, Brazil", EntidadeFlight.getPassengers()),
			new FlightDTO(Long.valueOf(0), "American AirLines", "21/12/2020", "05/01/2021", "New York, USA", EntidadeFlight.getPassengers()), 
			};

	private final FlightController flightController;

	FlightService(final FlightController flightController) {
		this.flightController = flightController;
		Arrays.asList(FlightService.DEFAULT_FLIGHTS).forEach(dto -> this.flightController.insertFlight(dto));
	}

	@GetMapping("/list")
	public List<FlightDTO> List() {
		return this.flightController.getAllFlights();
	}

	@GetMapping("/{id}/details")
	public ResponseEntity<FlightDTO> getFlight(@PathVariable final Long id) {
		final FlightDTO flight = this.flightController.getFlight(id);
		if (flight.equals(FlightDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<FlightDTO>(flight, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FlightDTO> removeFlight(@PathVariable final Long id) {
		final FlightDTO removedFlight = this.flightController.removeFlight(id);
		if (removedFlight.equals(FlightDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedFlight, HttpStatus.OK);
	}

	@DeleteMapping("/remove/passengerfromflight/{flightId}/{passengerId}")
	public ResponseEntity<FlightDTO> removePassengerFromFlight(@PathVariable final Long flightId,
			@PathVariable final Long passengerId) {
		final FlightDTO removedPassengerFromFlight = this.flightController.removePassengerFromFlight(flightId,
				passengerId);
		if (removedPassengerFromFlight.equals(FlightDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedPassengerFromFlight, HttpStatus.OK);
	}

	@GetMapping("/registerinflight/passenger/{flightId}/{passengerId}")
	public ResponseEntity<FlightDTO> registerPassenger(@PathVariable Long flightId, @PathVariable Long passengerId) {
		FlightDTO flight = this.flightController.registerPassengerOnAFlight(flightId, passengerId);
		if (flight == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(flight, HttpStatus.OK);
	}

	@PostMapping("/addflight")
	public Long insertFlight(@RequestBody final FlightDTO flight) {
		return this.flightController.insertFlight(flight);
	}

}
