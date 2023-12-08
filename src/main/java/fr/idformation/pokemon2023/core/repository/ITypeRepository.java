package fr.idformation.pokemon2023.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.idformation.pokemon2023.core.domain.Type;

public interface ITypeRepository extends JpaRepository<Type, Short> {

}
