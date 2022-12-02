/**
 * 
 */
package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Représente un rôle avec tous ses attributs
 * 
 * @author antPinot
 *
 */

@Entity
@Table
public class Role {
	
	/** id clé primaire*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** nom du personnage */
	@Column(name = "CHARACTER_NAME", length = 255)
	private String characterName;
	
	/** url */
	@Column(name = "URL")
	private String url;
	
	/** height */
	@Column(name = "HEIGHT", length = 10)
	private String height;
	
	/** films */
	@ManyToMany(mappedBy = "roles")
	private Set<Film> films = new HashSet<Film>();
	
	/** acteurs */
	@ManyToMany
	@JoinTable(name = "ROLE_ACTEUR", joinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ACTEUR", referencedColumnName = "ID"))
	private Set<Acteur> acteurs = new HashSet<Acteur>();

	/**Constructeur
	 * 
	 */
	public Role() {
	}

	/**Constructeur
	 * @param characterName
	 * @param url
	 * @param height
	 */
	public Role(String characterName, String url, String height) {
		this.characterName = characterName;
		this.url = url;
		this.height = height;
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

	/**Getter pour l'attribut height
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**Setter pour l'attribut height
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", characterName=" + characterName + ", url=" + url + ", height=" + height
				+ ", films=" + films + ", acteurs=" + acteurs + "]";
	}
	
}
