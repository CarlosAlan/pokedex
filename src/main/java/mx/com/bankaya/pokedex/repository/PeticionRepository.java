package mx.com.bankaya.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.bankaya.pokedex.entity.Peticion;

public interface PeticionRepository extends JpaRepository<Peticion, String> {

}
