package fr.idformation.pokemon2023.core.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pok_id")
	private Short id;

	@Column(name = "pok_name")
	private String name;

	@Column(name = "pok_cp")
	private Short combatPoint;

	@Column(name = "pok_hp")
	private Short healthPoint;

	@Column(name = "pok_picture")
	private String picture;

	@ManyToMany
	@JoinTable(name = "pokemon_type", joinColumns = {@JoinColumn(name = "pok_id")}, inverseJoinColumns = {
			@JoinColumn(name = "typ_id")})
	List<Type> types;

	/**
	 *
	 */
	public Pokemon() {
		super();
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the combatPoint
	 */
	public Short getCombatPoint() {
		return combatPoint;
	}

	/**
	 * @param combatPoint
	 *            the combatPoint to set
	 */
	public void setCombatPoint(Short combatPoint) {
		this.combatPoint = combatPoint;
	}

	/**
	 * @return the healthPoint
	 */
	public Short getHealthPoint() {
		return healthPoint;
	}

	/**
	 * @param healthPoint
	 *            the healthPoint to set
	 */
	public void setHealthPoint(Short healthPoint) {
		this.healthPoint = healthPoint;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture
	 *            the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the types
	 */
	public List<Type> getTypes() {
		return types;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(List<Type> types) {
		this.types = types;
	}

}
