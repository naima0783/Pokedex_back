package fr.idformation.pokemon2023.core.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "type")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typ_id")
	private Short id;

	@Column(name = "typ_label")
	private String label;

	@Column(name = "typ_color")
	private String color;

	@ManyToMany(mappedBy = "types")
	private Set<Pokemon> pokemons;

	/**
	 *
	 */
	public Type() {
		super();
	}

	public Type(short id) {
		super();
		this.id = id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the pokemons
	 */
	public Set<Pokemon> getPokemons() {
		return pokemons;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @param pokemons
	 *            the pokemons to set
	 */
	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
}
