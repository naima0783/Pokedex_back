package fr.idformation.pokemon2023.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.pokemon2023.core.domain.Pokemon;
import fr.idformation.pokemon2023.core.domain.Type;
import fr.idformation.pokemon2023.core.dto.PokemonDTO;

public class PokemonMapper {

	/**
	 *
	 * @param pokemons
	 *            a List of Pokemon
	 * @return the List of Pokemon turned into its sibling List of PokemonDTOs
	 */
	public static List<PokemonDTO> pokemonsToDtos(List<Pokemon> pokemons) {
		List<PokemonDTO> dtos = null;

		if (pokemons != null) {
			dtos = new ArrayList<>();

			for (Pokemon pokemon : pokemons) {
				dtos.add(pokemonToDto(pokemon));
			}
		}

		return dtos;
	}

	/**
	 *
	 * @param pokemon
	 *            a Pokemon
	 * @return the Pokemon turned into its sibling PokemonDTO
	 */
	public static PokemonDTO pokemonToDto(Pokemon pokemon) {
		PokemonDTO dto = null;

		if (pokemon != null) {
			dto = new PokemonDTO();

			dto.setId(pokemon.getId());
			dto.setCp(pokemon.getCombatPoint());
			dto.setHp(pokemon.getHealthPoint());
			dto.setName(pokemon.getName());
			dto.setPicture(pokemon.getPicture());

			if (pokemon.getTypes() != null && !pokemon.getTypes().isEmpty()) {
				List<Short> typeIds = new ArrayList<>();

				for (Type type : pokemon.getTypes()) {
					typeIds.add(type.getId());
				}

				dto.setTypes(typeIds);
			}
		}

		return dto;
	}

}
