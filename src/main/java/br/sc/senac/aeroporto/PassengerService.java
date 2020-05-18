package br.sc.senac.aeroporto;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/passenger")
public class PassengerService {
	
	private static PassengerDTO[] passengers = new PassengerDTO[] {
			new PassengerDTO(Long.valueOf(0), "John", "07/03/1992", "john@gmail.com"),
			new PassengerDTO(Long.valueOf(0), "Stone", "14/06/1994", "Stone@gmail.com"),
			new PassengerDTO(Long.valueOf(0), "Clone", "21/12/1996", "Clone@gmail.com"),
	};
	
	private final PassengerController passengerController;
	
	PassengerService(final PassengerController passengerController) {
		this.passengerController = passengerController;
		Arrays.asList(PassengerService.passengers).forEach(dto -> this.passengerController.insertPassenger(dto));
	}
	
	@GetMapping("list")
	public List<PassengerDTO> list() {
		return passengerController.getAllPassengers();
	}
	
	@PostMapping("/addpassenger")
	public Long insertPassenger(@RequestBody final PassengerDTO passenger) {
		return this.passengerController.insertPassenger(passenger);
	}

}
