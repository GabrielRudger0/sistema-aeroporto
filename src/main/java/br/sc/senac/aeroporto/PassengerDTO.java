package br.sc.senac.aeroporto;

public class PassengerDTO {

	public static final PassengerDTO NULL_VALUE = new PassengerDTO(Long.valueOf(0), "", "", "");

	private final Long id;
	private final String name;
	private final String birth_date;
	private final String email;

	public PassengerDTO(final Long id, final String name, final String birth_date, final String email) {

		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birth_date;
	}

	public String getEmail() {
		return email;
	}
}
