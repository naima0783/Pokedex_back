package fr.idformation.pokemon2023;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import fr.idformation.pokemon2023.core.domain.Type;
import fr.idformation.pokemon2023.core.dto.TypeDTO;
import fr.idformation.pokemon2023.core.dto.mapper.TypeMapper;

@SpringBootTest
public class TypeTest {

	/**
	 * Tests the default constructor for the mapper
	 */
	@Test
	public void defaultConstructor() {
		// given

		// when
		TypeMapper mapper = new TypeMapper();

		// then
		Assert.notNull(mapper, "default constructor returned a null object");
		Assert.isTrue(mapper.getClass().equals(TypeMapper.class), "default constructor returned a null object");
	}

	/**
	 * Tests if the mapping of a null object turns into a null dto
	 */
	@Test
	public void nullToDto() {
		// given
		Type type = null;

		// when
		TypeDTO dto = TypeMapper.typeToDto(type);

		// then
		Assert.isNull(dto, "dto should be null when entity is null");
	}

	/**
	 * Tests if the mapping of a non null type turns into a dto with the correct
	 * datas
	 */
	@Test
	public void typeToDto() {
		// given
		Type type = new Type();
		type.setId((short) 1);
		type.setLabel("pokemon1");
		type.setColor("color1");

		// when
		TypeDTO dto = TypeMapper.typeToDto(type);

		// then
		Assert.notNull(dto, "dto should be non null when entity is not null");
		Assert.isTrue(type.getId().equals(dto.getId()),
				"pokemon's id has changed. Got " + type.getId() + " found " + dto.getId());
		Assert.isTrue(type.getLabel().equals(dto.getLabel()),
				"pokemon's label has changed. Got " + type.getLabel() + " found " + dto.getLabel());
		Assert.isTrue(type.getColor().equals(dto.getColor()),
				"pokemon's color has changed. Got " + type.getColor() + " found " + dto.getColor());
	}

	/**
	 * Test if the mapping of a null List of type turns into a null dto List
	 */
	@Test
	public void nullToDtos() {
		// given
		List<Type> types = null;

		// when
		List<TypeDTO> dtos = TypeMapper.typesToDtos(types);

		// then
		Assert.isNull(dtos, "dtos should be null when entity List is null");
	}

	/**
	 * Tests if the mapping of an empty List of type turns into an empty dto
	 * List
	 */
	@Test
	public void emptyToDtos() {
		// given
		List<Type> types = new ArrayList<>();

		// when
		List<TypeDTO> dtos = TypeMapper.typesToDtos(types);

		// then
		Assert.notNull(dtos, "dtos shouldn't be null when entity List is empty");
		Assert.isTrue(dtos.isEmpty(), "dtos should be empty when entity List is empty");
	}

	/**
	 * Tests if the mapping of a not empty List of type turns into a not empty
	 * dto List with the same size
	 */
	@Test
	public void notEmptyToDtos() {
		// given
		List<Type> types = new ArrayList<>();
		for (short i = 0; i < 5; i++) {
			Type type = new Type();
			type.setId(i);
			type.setLabel("pokemon" + i);
			type.setColor("color" + i);
			types.add(type);
		}

		// when
		List<TypeDTO> dtos = TypeMapper.typesToDtos(types);

		// then
		Assert.notNull(dtos, "dtos shouldn't be null when entity List is not empty");
		Assert.isTrue(!dtos.isEmpty(), "dtos shouldn't be empty when entity List is not empty");
		Assert.isTrue(types.size() == dtos.size(), "dtos should have the same length than the entity List : found "
				+ dtos.size() + " instead of " + types.size());

		for (short i = 0; i < types.size(); i++) {
			Assert.notNull(dtos.get(i), "dto should be non null when entity is not null");
			Assert.isTrue(types.get(i).getId().equals(dtos.get(i).getId()),
					"pokemon's id has changed. Got " + types.get(i).getId() + " found " + dtos.get(i).getId());
			Assert.isTrue(types.get(i).getLabel().equals(dtos.get(i).getLabel()),
					"pokemon's label has changed. Got " + types.get(i).getLabel() + " found " + dtos.get(i).getLabel());
			Assert.isTrue(types.get(i).getColor().equals(dtos.get(i).getColor()),
					"pokemon's color has changed. Got " + types.get(i).getColor() + " found " + dtos.get(i).getColor());

		}
	}
}
