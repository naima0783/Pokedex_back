/**
 *
 */
package fr.idformation.pokemon2023.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.pokemon2023.core.domain.Pokemon;
import fr.idformation.pokemon2023.core.repository.IPokemonRepository;
import fr.idformation.pokemon2023.core.service.IPokemonService;

/**
 * @author piot
 *
 */
@Service
public class PokemonService implements IPokemonService {

	@Autowired
	private IPokemonRepository pokemonRepo;

	@Override
	public List<Pokemon> getAllPokemons() {
		return pokemonRepo.findAll();
	}

}
