package br.sc.senac.aeroporto;

import org.springframework.data.repository.CrudRepository;

interface FlightRepository extends CrudRepository<FlightEntity, Long> {

}
