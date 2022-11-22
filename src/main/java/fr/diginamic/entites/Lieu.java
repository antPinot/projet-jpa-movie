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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author antPinot
 *
 */
public class Lieu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "VILLE")
	private String ville;
	
	@Column(name = "ETAT_DEPT")
	private String etatDept;
	
	@ManyToOne
	@JoinColumn(name = "ID_PAYS_LIEU")
	private Pays pays;
	
	@OneToMany(mappedBy = "lieuNaissance")
	private Set<Acteur> acteurs = new HashSet<Acteur>();
	
	@OneToMany(mappedBy = "lieuTournage")
	private Set<Film> films = new HashSet<Film>();

	/**Constructeur
	 * 
	 */
	public Lieu() {
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

	/**Getter pour l'attribut ville
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**Setter pour l'attribut ville
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**Getter pour l'attribut etatDept
	 * @return the etatDept
	 */
	public String getEtatDept() {
		return etatDept;
	}

	/**Setter pour l'attribut etatDept
	 * @param etatDept the etatDept to set
	 */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}

	/**Getter pour l'attribut pays
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**Setter pour l'attribut pays
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
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
