package br.sc.senac.aeroporto;

import java.util.List;

public class FlightDTO {
	
	public static final FlightDTO NULL_VALUE = new FlightDTO(Long.valueOf(0), "", "", "", "", null);

	private final Long flightId;
	private final String airline;
	private final String date_departure;
	private final String date_back;
	private final String destination;
	private final List<PassengerEntity> passengers;

	public FlightDTO(final Long flightId, final String airline, final String date_departure, final String date_back,
			final String destination, final List<PassengerEntity> passengers) {

		this.flightId = flightId;
		this.airline = airline;
		this.date_departure = date_departure;
		this.date_back = date_back;
		this.destination = destination;
		this.passengers = passengers;
	}

	public Long getflightId() {
		return flightId;
	}

	public String getAirline() {
		return airline;
	}

	public String getDate_departure() {
		return date_departure;
	}

	public String getDate_back() {
		return date_back;
	}

	public String getDestination() {
		return destination;
	}

	public List<PassengerEntity> getPassengers() {
		return passengers;
	}

}
