package fr.diginamic.utils;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Lieu;
import fr.diginamic.entites.Pays;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

public class FilmDto {
	
	@JsonProperty("id")
	private String idImdb;

	private String nom;

	private String url;

	private String plot;

	private String langue;

	@JsonDeserialize(using = YearDeserializer.class)
	private Year anneeSortie;

	private Pays pays;

	@JsonInclude(Include.NON_NULL)
	private Lieu lieuTournage;
	
	private Set<Genre> genres = new HashSet<Genre>();
	
	private Set<Role> roles = new HashSet<Role>();
	
	@JsonProperty("castingPrincipal")
	private Set<Acteur> acteurs = new HashSet<Acteur>();
	
	private Set<Realisateur> realisateurs = new HashSet<Realisateur>();
	
	

	/**Constructeur
	 * 
	 */
	public FilmDto() {
	}

	/**Constructeur
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
	
	public FilmDto(String idImdb, String nom, String url, String plot, String langue, Year anneeSortie,
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

}
