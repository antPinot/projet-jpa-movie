/**
 * 
 */
package fr.diginamic.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author antPinot
 *
 */
public class Acteur extends Personne {
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(name = "ROLE_ACTEUR", joinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ACTEUR", referencedColumnName = "ID"))
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToMany(mappedBy = "acteurs")
	private Set<Film> films = new HashSet<Film>();
	
	

	/**Constructeur
	 * 
	 */
	public Acteur() {
	}



	/**Constructeur
	 * @param identite
	 * @param url
	 */
	public Acteur(String identite, String url) {
		super(identite, url);
		// TODO Auto-generated constructor stub
	}

}
