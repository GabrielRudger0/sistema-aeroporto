package br.sc.senac.aeroporto;

import br.sc.senac.aeroporto.PassengerDTO;
import br.sc.senac.aeroporto.PassengerEntity;

public class PassengerController {



private static void updateEntityFromDTO(final PassengerDTO PassengerDTO, final PassengerEntity PassengerEntity) {
	PassengerEntity.setName(PassengerDTO.getName());
	PassengerEntity.setEmail(PassengerDTO.getEmail());
	PassengerEntity.setDate(PassengerDTO.getBirthDate());
}
}