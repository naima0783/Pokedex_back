package fr.idformation.pokemon2023.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.idformation.pokemon2023.core.dto.TypeDTO;
import fr.idformation.pokemon2023.core.dto.mapper.TypeMapper;
import fr.idformation.pokemon2023.core.service.ITypeService;

@RestController
@RequestMapping("/type")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class PokemonTypeController {

	@Autowired
	private ITypeService typeService;

	/**
	 * @return all Type
	 */
	@GetMapping("/")
	public List<TypeDTO> getAll() {
		return TypeMapper.typesToDtos(typeService.getAllTypes());
	}
}
