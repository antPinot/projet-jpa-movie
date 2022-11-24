/**
 * 
 */
package fr.diginamic.entites;

import java.time.Year;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Représente un film avec tous ses attributs
 * 
 * @author antPinot
 *
 */

@Entity
@Table
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** idImdb représente la clé métier de la base IMDB*/
	@Column(name = "ID_IMDB", nullable = false, unique = true)
	private String idImdb;
	
	/** nom du film*/
	@Column(name = "NOM")
	private String nom;
	
	/** url sur le site imdb*/
	@Column(name = "URL")
	private String url;
	
	/** plot(synopsis) du film*/
	@Column(name = "PLOT")
	private String plot;

	/** langue du film*/
	@Column(name = "LANGUE")
	private String langue;

	/** année de sortie du film*/
	@Column(name = "ANNEE_SORTIE")
	private Year anneeSortie;

	/** Pays d'origine du film*/
	@ManyToOne
	@JoinColumn(name = "ID_PAYS_FILM")
	private Pays pays;

	/** Lieu de tournage du film*/
	@ManyToOne
	@JoinColumn(name = "ID_LIEU_FILM")
	private Lieu lieuTournage;

	/** Genres associés au film*/
	@ManyToMany
	@JoinTable(name = "GENRE_FILM", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_GENRE", referencedColumnName = "ID"))
	private Set<Genre> genres = new HashSet<Genre>();
	
	/** Roles associés au film*/
	@ManyToMany
	@JoinTable(name = "ROLE_FILM", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
	private Set<Role> roles = new HashSet<Role>();
	
	/*@ManyToMany
	@JoinTable(name = "PERSONNE_FILM", joinColumns = @JoinColumn(name = "ID_PERSONNE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"))
	private Set<Personne> personnes = new HashSet<Personne>();*/
	
	/** Acteurs associés au film*/
	@ManyToMany
	@JoinTable(name = "ACTEUR_FILM", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ACTEUR", referencedColumnName = "ID"))
	private Set<Acteur> acteurs = new HashSet<Acteur>();
	
	/** Réalisateurs associés au film*/
	@ManyToMany
	@JoinTable(name = "REALISATEUR_FILM", joinColumns = @JoinColumn(name = "ID_FILM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_REALISATEUR", referencedColumnName = "ID"))
	private Set<Realisateur> realisateurs = new HashSet<Realisateur>();

	/**
	 * Constructeur vide pour la construction des entités Hibernate
	 * 
	 */
	public Film() {
	}
	
	

	/**Constructeur secondaire basé uniquement sur la clé métier imdb
	 * 
	 * @param idImdb 
	 */
	public Film(String idImdb) {
		super();
		this.idImdb = idImdb;
	}



	/**Constructeur
	 * @param id
	 * @param idImdb
	 * @param nom
	 * @param url
	 * @param plot
	 * @param langue
	 * @param anneeSortie
	 * @param pays
	 * @param lieuTournage
	 * @param genres
	 * @param roles
	 * @param acteurs
	 * @param realisateurs
	 */
	public Film(String idImdb, String nom, String url, String plot, String langue, Year anneeSortie,
			Pays pays, Lieu lieuTournage, Set<Genre> genres, Set<Role> roles, Set<Acteur> acteurs,
			Set<Realisateur> realisateurs) {
		this.idImdb = idImdb;
		this.nom = nom;
		this.url = url;
		this.plot = plot;
		this.langue = langue;
		this.anneeSortie = anneeSortie;
		this.pays = pays;
		this.lieuTournage = lieuTournage;
		this.genres = genres;
		this.roles = roles;
		this.acteurs = acteurs;
		this.realisateurs = realisateurs;
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

	/**Getter pour l'attribut idImdb
	 * @return the idImdb
	 */
	public String getIdImdb() {
		return idImdb;
	}

	/**Setter pour l'attribut idImdb
	 * @param idImdb the idImdb to set
	 */
	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
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

	/**Getter pour l'attribut plot
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**Setter pour l'attribut plot
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**Getter pour l'attribut langue
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}

	/**Setter pour l'attribut langue
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/**Getter pour l'attribut anneeSortie
	 * @return the anneeSortie
	 */
	public Year getAnneeSortie() {
		return anneeSortie;
	}

	/**Setter pour l'attribut anneeSortie
	 * @param anneeSortie the anneeSortie to set
	 */
	public void setAnneeSortie(Year anneeSortie) {
		this.anneeSortie = anneeSortie;
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

	/**Getter pour l'attribut lieuTournage
	 * @return the lieuTournage
	 */
	public Lieu getLieuTournage() {
		return lieuTournage;
	}

	/**Setter pour l'attribut lieuTournage
	 * @param lieuTournage the lieuTournage to set
	 */
	public void setLieuTournage(Lieu lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/**Getter pour l'attribut genres
	 * @return the genres
	 */
	public Set<Genre> getGenres() {
		return genres;
	}

	/**Setter pour l'attribut genres
	 * @param genres the genres to set
	 */
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	/**Getter pour l'attribut roles
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**Setter pour l'attribut roles
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	/**Getter pour l'attribut realisateurs
	 * @return the realisateurs
	 */
	public Set<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/**Setter pour l'attribut realisateurs
	 * @param realisateurs the realisateurs to set
	 */
	public void setRealisateurs(Set<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", idImdb=" + idImdb + ", nom=" + nom + ", url=" + url + ", plot=" + plot
				+ ", langue=" + langue + ", anneeSortie=" + anneeSortie + ", pays=" + pays + ", lieuTournage="
				+ lieuTournage + ", genres=" + genres + ", roles=" + roles + ", acteurs=" + acteurs + ", realisateurs="
				+ realisateurs + "]";
	}
	

}
