package fr.idformation.pokemon2023;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import fr.idformation.pokemon2023.core.domain.Pokemon;
import fr.idformation.pokemon2023.core.domain.Type;
import fr.idformation.pokemon2023.core.dto.PokemonDTO;
import fr.idformation.pokemon2023.core.dto.mapper.PokemonMapper;

@SpringBootTest
public class PokemonTest {

	/**
	 * Tests the default constructor for the mapper
	 */
	@Test
	public void defaultConstructor() {
		// given

		// when
		PokemonMapper mapper = new PokemonMapper();

		// then
		Assert.notNull(mapper, "default constructor returned a null object");
		Assert.isTrue(mapper.getClass().equals(PokemonMapper.class), "default constructor returned a null object");
	}

	/**
	 * Tests if the mapping of a null object turns into a null dto
	 */
	@Test
	public void nullToDto() {
		// given
		Pokemon pokemon = null;

		// when
		PokemonDTO dto = PokemonMapper.pokemonToDto(pokemon);

		// then
		Assert.isNull(dto, "dto should be null when entity is null");
	}

	/**
	 * Tests if the mapping of a non null pokemon turns into a dto with the
	 * correct datas
	 */
	@Test
	public void pokemonToDto() {
		// given
		Pokemon pokemon = new Pokemon();
		pokemon.setId((short) 1);
		pokemon.setCombatPoint((short) 11);
		pokemon.setHealthPoint((short) 21);
		pokemon.setName("pokemon1");
		pokemon.setPicture("url1");

		List<Type> typeIds = new ArrayList<>();
		typeIds.add(new Type((short) 1));
		pokemon.setTypes(typeIds);

		// when
		PokemonDTO dto = PokemonMapper.pokemonToDto(pokemon);

		// then
		Assert.notNull(dto, "dto should be non null when entity is not null");
		Assert.isTrue(pokemon.getId().equals(dto.getId()),
				"pokemon's id has changed. Got " + pokemon.getId() + " found " + dto.getId());
		Assert.isTrue(pokemon.getCombatPoint().equals(dto.getCp()),
				"pokemon's cp has changed. Got " + pokemon.getCombatPoint() + " found " + dto.getCp());
		Assert.isTrue(pokemon.getHealthPoint().equals(dto.getHp()),
				"pokemon's hp has changed. Got " + pokemon.getHealthPoint() + " found " + dto.getHp());
		Assert.isTrue(pokemon.getName().equals(dto.getName()),
				"pokemon's name has changed. Got " + pokemon.getName() + " found " + dto.getName());
		Assert.isTrue(pokemon.getPicture().equals(dto.getPicture()),
				"pokemon's picture has changed. Got " + pokemon.getPicture() + " found " + dto.getPicture());
		Assert.isTrue(pokemon.getTypes().size() == dto.getTypes().size(), "pokemon's types size has changed");

	}

	/**
	 * Tests if the mapping of a Pokemon with a null List of Type send null
	 * types in DTO
	 */
	@Test
	public void pokemonWithNullTypesToDto() {
		// given
		Pokemon pokemon = new Pokemon();

		// when
		PokemonDTO dto = PokemonMapper.pokemonToDto(pokemon);

		// then
		Assert.notNull(dto, "dto shouldn't be null when entity is not empty");
		Assert.isNull(dto.getTypes(), "pokemon's types should be null");
	}

	/**
	 * Tests if the mapping of a Pokemon with a empty List of Type send null
	 * types in DTO
	 */
	@Test
	public void pokemonWithEmptyTypesToDto() {
		// given
		Pokemon pokemon = new Pokemon();
		pokemon.setTypes(new ArrayList<>());

		// when
		PokemonDTO dto = PokemonMapper.pokemonToDto(pokemon);

		// then
		Assert.notNull(dto, "dto shouldn't be null when entity is not empty");
		Assert.isNull(dto.getTypes(), "pokemon's types should be null");
	}

	/**
	 * Test if the mapping of a null List of pokemon turns into a null dto List
	 */
	@Test
	public void nullToDtos() {
		// given
		List<Pokemon> pokemons = null;

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDtos(pokemons);

		// then
		Assert.isNull(dtos, "dtos should be null when entity List is null");
	}

	/**
	 * Tests if the mapping of an empty List of pokemon turns into an empty dto
	 * List
	 */
	@Test
	public void emptyToDtos() {
		// given
		List<Pokemon> pokemons = new ArrayList<>();

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDtos(pokemons);

		// then
		Assert.notNull(dtos, "dtos shouldn't be null when entity List is empty");
		Assert.isTrue(dtos.isEmpty(), "dtos should be empty when entity List is empty");
	}

	/**
	 * Tests if the mapping of a not empty List of pokemon turns into a not
	 * empty dto List with the same size
	 */
	@Test
	public void notEmptyToDtos() {
		// given
		List<Pokemon> pokemons = new ArrayList<>();
		for (short i = 0; i < 5; i++) {
			Pokemon pokemon = new Pokemon();
			pokemon.setId(i);
			pokemon.setCombatPoint((short) (10 + i));
			pokemon.setHealthPoint((short) (20 + i));
			pokemon.setName("pokemon" + i);
			pokemon.setPicture("url" + i);

			List<Type> typeIds = new ArrayList<>();
			typeIds.add(new Type(i));
			pokemon.setTypes(typeIds);

			pokemons.add(pokemon);
		}

		// when
		List<PokemonDTO> dtos = PokemonMapper.pokemonsToDtos(pokemons);

		// then
		Assert.notNull(dtos, "dtos shouldn't be null when entity List is not empty");
		Assert.isTrue(!dtos.isEmpty(), "dtos shouldn't be empty when entity List is not empty");
		Assert.isTrue(pokemons.size() == dtos.size(), "dtos should have the same length than the entity List : found "
				+ dtos.size() + " instead of " + pokemons.size());

		for (short i = 0; i < pokemons.size(); i++) {
			Assert.notNull(dtos.get(i), "dto should be non null when entity is not null");
			Assert.isTrue(pokemons.get(i).getId().equals(dtos.get(i).getId()),
					"pokemon's id has changed. Got " + pokemons.get(i).getId() + " found " + dtos.get(i).getId());
			Assert.isTrue(pokemons.get(i).getCombatPoint().equals(dtos.get(i).getCp()), "pokemon's cp has changed. Got "
					+ pokemons.get(i).getCombatPoint() + " found " + dtos.get(i).getCp());
			Assert.isTrue(pokemons.get(i).getHealthPoint().equals(dtos.get(i).getHp()), "pokemon's hp has changed. Got "
					+ pokemons.get(i).getHealthPoint() + " found " + dtos.get(i).getHp());
			Assert.isTrue(pokemons.get(i).getName().equals(dtos.get(i).getName()),
					"pokemon's name has changed. Got " + pokemons.get(i).getName() + " found " + dtos.get(i).getName());
			Assert.isTrue(pokemons.get(i).getPicture().equals(dtos.get(i).getPicture()),
					"pokemon's picture has changed. Got " + pokemons.get(i).getPicture() + " found "
							+ dtos.get(i).getPicture());
			Assert.isTrue(pokemons.get(i).getTypes().size() == dtos.get(i).getTypes().size(),
					"pokemon's types size has changed");
		}
	}

}
