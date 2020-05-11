package br.sc.senac.aeroporto;

public class PassengerDTO {

	public static final PassengerDTO NULL_VALUE = new PassengerDTO("", "", "", "", "");
	
	private final String name;
	private final String birth_date;
	private final String email;
	private final String phone;
	private final String cpf;

	public PassengerDTO(final String name, final String birth_date, final String email,
			final String phone, final String cpf) {

		this.name = name;
		this.birth_date = birth_date;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
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

	public String getPhone() {
		return phone;
	}

	public String getCpf() {
		return cpf;
	}

}
