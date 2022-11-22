/**
 * 
 */
package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author antPinot
 *
 */
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CHARACTER_NAME")
	private String characterName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Film> films = new HashSet<Film>();
	
	@ManyToMany(mappedBy = "roles")
	private Set<Acteur> acteurs = new HashSet<Acteur>();

	/**Constructeur
	 * 
	 */
	public Role() {
	}

	/**Getter pour l'attribut id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**Setter pour l'attribut id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter pour l'attribut characterName
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**Setter pour l'attribut characterName
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**Getter pour l'attribut films
	 * @return the films
	 */
	public Set<Film> getFilms() {
		return films;
	}

	/**Setter pour l'attribut films
	 * @param films the films to set
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	/**Getter pour l'attribut acteurs
	 * @return the acteurs
	 */
	public Set<Acteur> getActeurs() {
		return acteurs;
	}

	/**Setter pour l'attribut acteurs
	 * @param acteurs the acteurs to set
	 */
	public void setActeurs(Set<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

}
