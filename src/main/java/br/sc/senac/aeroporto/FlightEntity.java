package br.sc.senac.aeroporto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Flight")
final class FlightEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flightId;
	
	private PassengerDTO passenger;
	
	private String airline;
	
	private String date_departure;
	
	private String date_back;
	
	private String destination;
	
	protected FlightEntity() {
	}
	
	public FlightEntity(final PassengerDTO passenger, final String airline, final String date_departure,
			final String date_back, final String destination) {

		this.passenger = passenger;
		this.airline = airline;
		this.date_departure = date_departure;
		this.date_back = date_back;
		this.destination = destination;

	}
	
	@Override
	public String toString() {
		return "FlightEntity [FlightId=" + this.flightId + ", passenger=" + this.passenger + ", airlane=" + this.airline
				+ ", date departure=" + this.date_departure + ", date back =" + this.date_back + ", destination="
				+ this.destination + "]";
	}

	public Long getFlightId() {
		return this.flightId;
	}

	public PassengerDTO getPassenger() {
		return this.passenger;
	}

	public void setPassenger(final PassengerDTO passenger) {
		if (passenger != null) {
			this.passenger = passenger;
		}
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		if (airline != null) {
			this.airline = airline;
		}

	}

	public String getDate_departure() {
		return date_departure;
	}

	public void setDate_departure(String date_departure) {
		if (date_departure != null) {
			this.date_departure = date_departure;
		}

	}

	public String getDate_back() {
		return date_back;
	}

	public void setDate_back(String date_back) {
		if (date_back != null) {
			this.date_back = date_back;
		}

	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		if (destination != null) {
			this.destination = destination;
		}

	}

}
