package br.sc.senac.aeroporto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Flight")
final class FlightEntity implements Serializable {

	private static final long serialVersionUID = 8177572400344866171L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flightId;
	
	@ManyToMany
	private final List<PassengerEntity> passengers;

	private String airline;

	private String date_departure;

	private String date_back;

	private String destination;

	protected FlightEntity() {
		this.passengers = null;
	}

	public FlightEntity(final String airline, final String date_departure, final String date_back,
			final String destination) {

		this.passengers = null;
		this.airline = airline;
		this.date_departure = date_departure;
		this.date_back = date_back;
		this.destination = destination;

	}

	@Override
	public String toString() {
		return "FlightEntity [Flight Id=" + this.flightId + ", airlane=" + this.airline + ", date departure="
				+ this.date_departure + ", date back =" + this.date_back + ", destination=" + this.destination + "]";
	}

	public Long getFlightId() {
		return this.flightId;
	}
	
	public List<PassengerEntity> getPassengers() {
		return passengers;
	}
	
	public List<PassengerEntity> addPassengers(PassengerEntity passenger) {
		this.passengers.add(passenger);
		return passengers;
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
