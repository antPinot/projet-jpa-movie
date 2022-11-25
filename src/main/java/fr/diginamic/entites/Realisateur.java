/**
 * 
 */
package fr.diginamic.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Représente un réalisateur avec tous ses attributs
 * <p>
 * Classe fille de Personne
 * 
 * @author antPinot
 *
 */

@Entity
@Table
public class Realisateur extends Personne {
	
	/** films */
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

	@Override
	public String toString() {
		
		return super.toString() + "Realisateur [films=" + films + "]";
	}

	
	

}
