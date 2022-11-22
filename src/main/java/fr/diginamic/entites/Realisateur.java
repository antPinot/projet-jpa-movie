/**
 * 
 */
package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;

/**
 * @author antPinot
 *
 */
public class Realisateur extends Personne {
	
	@ManyToMany(mappedBy = "realisateurs")
	private Set<Film> films = new HashSet<Film>();
	
	/**Constructeur
	 * 
	 */
	public Realisateur() {
	}

	/**Constructeur
	 * @param identite
	 * @param url
	 */
	public Realisateur(String identite, String url) {
		super(identite, url);
		// TODO Auto-generated constructor stub
	}

}
