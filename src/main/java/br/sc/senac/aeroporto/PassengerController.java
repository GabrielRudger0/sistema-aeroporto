package br.sc.senac.aeroporto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import br.sc.senac.aeroporto.PassengerDTO;
import br.sc.senac.aeroporto.PassengerEntity;

@Controller
public class PassengerController {

	private final PassengerRepository passengerRepository;

	PassengerController(final PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}
	
	private static void updateEntityFromDTO(final PassengerDTO passengerDTO, final PassengerEntity passengerEntity) {
		passengerEntity.setName(passengerDTO.getName());
		passengerEntity.setEmail(passengerDTO.getEmail());
		passengerEntity.setDate(passengerDTO.getBirthDate());
	}

	private static PassengerEntity toEntity(final PassengerDTO passengerDTO) {
		final String name = passengerDTO.getName();
		final String email = passengerDTO.getEmail();
		final String birth_date = passengerDTO.getBirthDate();
		return new PassengerEntity(name, email, birth_date);
	}

	public static PassengerDTO toDTO(final PassengerEntity passengerEntity) {
		final Long id = passengerEntity.getPassengerId();
		final String name = passengerEntity.getName();
		final String date = passengerEntity.getDate();
		final String email = passengerEntity.getEmail();
		return new PassengerDTO(id, name, date, email);
	}
	
	List<PassengerDTO> getAllPassengers() {
		final List<PassengerDTO> passengers = new ArrayList<>();
		
		final Iterable<PassengerEntity> entities = this.passengerRepository.findAll();
		for (final PassengerEntity PassengerEntity : entities) {
		PassengerDTO PassengerDTO = PassengerController.toDTO(PassengerEntity);
		passengers.add(PassengerDTO);
		}
		return passengers;
	}
	
	PassengerDTO getPassenger(final Long id) {
		final Optional<PassengerEntity> optionalPassenger = this.passengerRepository.findById(id);
		if (optionalPassenger.isPresent()) {
			return PassengerController.toDTO(optionalPassenger.get());
		}
		return PassengerDTO.NULL_VALUE;
	}

	Long insertPassenger(final PassengerDTO passengerDTO) {
		final PassengerEntity passengerEntity = PassengerController.toEntity(passengerDTO);
		this.passengerRepository.save(passengerEntity);
		return passengerEntity.getPassengerId();
	}
	
	List<PassengerDTO> updatePassenger(final Long id, final PassengerDTO passengerDTO) {
		final Optional<PassengerEntity> optinalPassenger = this.passengerRepository.findById(id);

		if (optinalPassenger.isPresent()) {
			final List<PassengerDTO> oldPassengerNewPassenger = new ArrayList<>();

			final PassengerEntity passengerEntity = optinalPassenger.get();
			final PassengerDTO oldPassengerDTO = PassengerController.toDTO(passengerEntity);
			PassengerController.updateEntityFromDTO(passengerDTO, passengerEntity);
			this.passengerRepository.save(passengerEntity);
			oldPassengerNewPassenger.add(PassengerController.toDTO(passengerEntity));
			oldPassengerNewPassenger.add(oldPassengerDTO);

			return oldPassengerNewPassenger;
		}
		return new ArrayList<PassengerDTO>();
	}

}