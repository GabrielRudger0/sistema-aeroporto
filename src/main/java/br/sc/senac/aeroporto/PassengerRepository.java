package br.sc.senac.aeroporto;

import org.springframework.data.repository.CrudRepository;

interface PassengerRepository extends CrudRepository<PassengerEntity, Long> {

}