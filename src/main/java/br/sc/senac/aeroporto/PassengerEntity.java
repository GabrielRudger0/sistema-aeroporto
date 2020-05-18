package br.sc.senac.aeroporto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Passenger")
final class PassengerEntity implements Serializable {

	private static final long serialVersionUID = 4391164751402917205L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long PassengerId;

	private String name;

	private String date;

	private String email;

	protected PassengerEntity() {
	}

	public PassengerEntity(final String name, final String date, final String email) {
		this.name = name;
		this.date = date;
		this.email = email;
	}

	@Override
	public String toString() {
		return "PassengerEntity [PassengerId=" + this.PassengerId + ", name=" + this.name + ", date=" + this.date
				+ ", email=" + this.email + "]";
	}

	public Long getPassengerId() {

		return this.PassengerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		if (name != null) {
			this.name = name;
		}
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(final String date) {
		if (date != null) {
			this.date = date;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		if (email != null) {
			this.email = email;
		}
	}

}
