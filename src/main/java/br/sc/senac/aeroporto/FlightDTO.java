package br.sc.senac.aeroporto;

public class FlightDTO {
	
	public static final PassengerEntity NULL_PASSENGER = new PassengerEntity("", "", "");
	public static final FlightDTO NULL_VALUE = new FlightDTO(NULL_PASSENGER, "", "", "", "");
	
	private final PassengerEntity passenger;
	private final String airline;
	private final String date_departure;
	private final String date_back;
	private final String destination;

	public FlightDTO(final PassengerEntity passenger,final String airline, final String date_departure, final String date_back,
			final String destination) {
		
		this.passenger = passenger;
		this.airline = airline;
		this.date_departure = date_departure;
		this.date_back = date_departure;
		this.destination = destination;
	}

	public PassengerEntity getPassenger() {
		return passenger;
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

}
