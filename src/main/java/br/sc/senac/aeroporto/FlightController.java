package br.sc.senac.aeroporto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class FlightController {

	private final FlightRepository flightRepository;
	private final PassengerRepository passengerRepository;

	FlightController(final FlightRepository flightRepository, final PassengerRepository passengerRepository) {
		this.flightRepository = flightRepository;
		this.passengerRepository = passengerRepository;
	}

	private static void updateEntityFromDTO(final FlightDTO flightDTO, final FlightEntity flightEntity) {
		flightEntity.setAirline(flightDTO.getAirline());
		flightEntity.setDestination(flightDTO.getDestination());
		flightEntity.setDate_departure(flightDTO.getDate_departure());
		flightEntity.setDate_back(flightDTO.getDate_back());
	}
	
	private static FlightEntity toEntity(final FlightDTO flightDTO) {
		final String airline = flightDTO.getAirline();
		final String date_departure = flightDTO.getDate_departure();
		final String date_back = flightDTO.getDate_back();
		final String destination = flightDTO.getDestination();
		return new FlightEntity(airline, date_departure, date_back, destination);
	}

	private static FlightDTO toDTO(final FlightEntity FlightEntity) {
		final String airline = FlightEntity.getAirline();
		final String destination = FlightEntity.getDestination();
		final String date_departure = FlightEntity.getDate_departure();
		final String date_back = FlightEntity.getDate_back();
		return new FlightDTO(FlightDTO.NULL_PASSENGER,airline, destination, date_departure, date_back);
	}

	List<FlightDTO> getAllFlights() {
		final List<FlightDTO> flights = new ArrayList<>();

		final Iterable<FlightEntity> entities = this.flightRepository.findAll();
		for (final FlightEntity FlightEntity : entities) {
			FlightDTO FlightDTO = FlightController.toDTO(FlightEntity);
			flights.add(FlightDTO);
		}
		return flights;
	}

	FlightDTO registerPassengerOnAFlight(final Long flightId, final Long passengerId) {
		final Optional<FlightEntity> optionalFlight = this.flightRepository.findById(flightId);
		final Optional<PassengerEntity> optionalPassenge = this.passengerRepository.findById(passengerId);
		
				
		if (optionalFlight.isPresent()) {
			if (optionalPassenge.isPresent()) {
			PassengerEntity passengerEntity = optionalPassenge.get();
			FlightEntity flightEntity = optionalFlight.get();
			flightEntity.addPassengers(passengerEntity);
			return FlightController.toDTO(flightEntity);
			}
		}
		return FlightDTO.NULL_VALUE;
	}
	
	Long insertFlight(final FlightDTO flightDTO) {
		final FlightEntity flightEntity = FlightController.toEntity(flightDTO);
		this.flightRepository.save(flightEntity);
		return flightEntity.getFlightId();
	}

}
