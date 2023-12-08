package fr.idformation.pokemon2023.core.service;

import java.util.List;

import fr.idformation.pokemon2023.core.domain.Type;

public interface ITypeService {

	/**
	 *
	 * @return all pokemon pokemons
	 */
	public List<Type> getAllTypes();

}
