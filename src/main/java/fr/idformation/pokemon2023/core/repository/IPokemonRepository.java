package fr.idformation.pokemon2023.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.idformation.pokemon2023.core.domain.Pokemon;

@Repository
public interface IPokemonRepository extends JpaRepository<Pokemon, Short> {

}
