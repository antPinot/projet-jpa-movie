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
	private Integer id;
	
	@Column(name = "IDENTITE")
	private String identite;
	
	@Column(name = "URL")
	private String url;

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
	

}


