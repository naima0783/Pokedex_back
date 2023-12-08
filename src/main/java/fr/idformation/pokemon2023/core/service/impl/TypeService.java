package fr.idformation.pokemon2023.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.idformation.pokemon2023.core.domain.Type;
import fr.idformation.pokemon2023.core.repository.ITypeRepository;
import fr.idformation.pokemon2023.core.service.ITypeService;

@Service
public class TypeService implements ITypeService {

	@Autowired
	private ITypeRepository typeRepo;

	@Override
	public List<Type> getAllTypes() {
		return typeRepo.findAll();
	}

}
