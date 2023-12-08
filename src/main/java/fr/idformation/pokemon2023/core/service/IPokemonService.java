package fr.idformation.pokemon2023.core.service;

import java.util.List;

import fr.idformation.pokemon2023.core.domain.Pokemon;

public interface IPokemonService {

	/**
	 * 
	 * @return all the pokemons known in the DB
	 */
	public List<Pokemon> getAllPokemons();
}
