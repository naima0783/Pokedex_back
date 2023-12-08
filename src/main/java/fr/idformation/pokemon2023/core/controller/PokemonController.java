package fr.idformation.pokemon2023.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.pokemon2023.core.dto.PokemonDTO;
import fr.idformation.pokemon2023.core.dto.mapper.PokemonMapper;
import fr.idformation.pokemon2023.core.service.IPokemonService;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class PokemonController {

	@Autowired
	private IPokemonService pokemonService;

	/**
	 * @return all the pokemons as a List of PokemonDTO
	 */
	@GetMapping("/")
	public List<PokemonDTO> getAll() {
		return PokemonMapper.pokemonsToDtos(pokemonService.getAllPokemons());
	}
}
