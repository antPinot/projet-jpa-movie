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
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "LIBELLE")
	private String libelle;
	
	@ManyToMany(mappedBy = "genres")
	private Set<Film> films = new HashSet<Film>();

	/**Constructeur
	 * 
	 */
	public Genre() {
	}

	/**Constructeur
	 * @param libelle
	 */
	public Genre(String libelle) {
		this.libelle = libelle;
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

	/**Getter pour l'attribut libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**Setter pour l'attribut libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	

}


