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
import javax.persistence.OneToMany;

/**
 * @author antPinot
 *
 */
public class Pays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "URL")
	private String url;
	
	@OneToMany(mappedBy = "pays")
	private Set<Film> films = new HashSet<Film>();
	
	@OneToMany(mappedBy = "pays")
	private Set<Lieu> lieux = new HashSet<Lieu>();

	/**Constructeur
	 * 
	 */
	public Pays() {
	}
	

	/**Constructeur
	 * @param nom
	 */
	public Pays(String nom) {
		this.nom = nom;
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

	/**Getter pour l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter pour l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter pour l'attribut url
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**Setter pour l'attribut url
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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

	/**Getter pour l'attribut lieux
	 * @return the lieux
	 */
	public Set<Lieu> getLieux() {
		return lieux;
	}

	/**Setter pour l'attribut lieux
	 * @param lieux the lieux to set
	 */
	public void setLieux(Set<Lieu> lieux) {
		this.lieux = lieux;
	}
	
}
