/**
 * 
 */
package fr.diginamic.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente un acteur avec tous ses attributs
 * <p>
 * Classe fille de Personne
 * 
 * @author antPinot
 *
 */

@Entity
@Table
public class Acteur extends Personne {

	/** idImdb clé métier de la base imdb*/
	@Column(name = "ID_IMDB")
	private String idImdb;

	/** height */
	@Column(name = "HEIGHT", length = 10)
	private String height;

	/** dateNaissance */
	@Column(name = "DATE_NAISSANCE")
	private LocalDate dateNaissance;

	/** lieuNaissance */
	@ManyToOne
	@JoinColumn(name = "ID_LIEU_NAISSANCE")
	private Lieu lieuNaissance;

	/** roles liste(set) des roles de l'acteur */
	@ManyToMany
	@JoinTable(name = "ROLE_ACTEUR", joinColumns = @JoinColumn(name = "ID_ACTEUR", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
	private Set<Role> roles = new HashSet<Role>();

	/** films list(set) des films de l'acteur */
	@ManyToMany(mappedBy = "acteurs")
	private Set<Film> films = new HashSet<Film>();

	/**
	 * Constructeur
	 * 
	 */
	public Acteur() {
	}

	/**
	 * Constructeur
	 * 
	 * @param identite
	 * @param url
	 */
	public Acteur(String identite, String url) {
		super(identite, url);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur
	 * 
	 * @param idImdb
	 * @param height
	 * @param dateNaissance
	 * @param lieuNaissance
	 */
	public Acteur(String identite, String url, String idImdb, String height, LocalDate dateNaissance,
			Lieu lieuNaissance) {
		super(identite, url);
		this.idImdb = idImdb;
		this.height = height;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

	/**
	 * Getter pour l'attribut height
	 * 
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Setter pour l'attribut height
	 * 
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Getter pour l'attribut dateNaissance
	 * 
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 * 
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut roles
	 * 
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Setter pour l'attribut roles
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * Getter pour l'attribut films
	 * 
	 * @return the films
	 */
	public Set<Film> getFilms() {
		return films;
	}

	/**
	 * Setter pour l'attribut films
	 * 
	 * @param films the films to set
	 */
	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	/**
	 * Getter pour l'attribut idImdb
	 * 
	 * @return the idImdb
	 */
	public String getIdImdb() {
		return idImdb;
	}

	/**
	 * Setter pour l'attribut idImdb
	 * 
	 * @param idImdb the idImdb to set
	 */
	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
	}

	/**
	 * Getter pour l'attribut lieuNaissance
	 * 
	 * @return the lieuNaissance
	 */
	public Lieu getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * Setter pour l'attribut lieuNaissance
	 * 
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(Lieu lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	@Override
	public String toString() {
		return super.toString() + "Acteur [idImdb=" + idImdb + ", height=" + height + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", roles=" + roles + ", films=" + films + "]";
	}

}
