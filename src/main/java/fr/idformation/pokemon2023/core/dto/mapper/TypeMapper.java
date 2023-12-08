package fr.idformation.pokemon2023.core.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import fr.idformation.pokemon2023.core.domain.Type;
import fr.idformation.pokemon2023.core.dto.TypeDTO;

public class TypeMapper {

	/**
	 * Convert a List of type into a list of typeDTO
	 *
	 * @param types
	 *            the list to convert
	 * @return the sibling DTO List of types
	 */
	public static List<TypeDTO> typesToDtos(List<Type> types) {
		List<TypeDTO> dtos = null;

		if (types != null) {
			dtos = new ArrayList<>();
			for (Type type : types) {
				dtos.add(typeToDto(type));
			}
		}

		return dtos;
	}

	/**
	 * Convert a Type into a TypeDTO
	 *
	 * @param type
	 *            the type to convert
	 * @return the TypeDTO representation of the given Type
	 */
	public static TypeDTO typeToDto(Type type) {

		TypeDTO dto = null;

		if (type != null) {
			dto = new TypeDTO();

			dto.setId(type.getId());
			dto.setLabel(type.getLabel());
			dto.setColor(type.getColor());
		}

		return dto;
	}

}
