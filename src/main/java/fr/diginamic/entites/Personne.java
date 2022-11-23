/**
 * 
 */
package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



/**
 * @author antPinot
 *
 */

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name = "IDENTITE")
	protected String identite;
	
	@Column(name = "URL")
	protected String url;

	public Personne() {
	}

	/**Constructeur
	 * @param identite
	 * @param url
	 */
	public Personne(String identite, String url) {
		this.identite = identite;
		this.url = url;
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

	/**Getter pour l'attribut identite
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}

	/**Setter pour l'attribut identite
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
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

	@Override
	public String toString() {
		return "Personne [id=" + id + ", identite=" + identite + ", url=" + url + "]";
	}
	
	

}


