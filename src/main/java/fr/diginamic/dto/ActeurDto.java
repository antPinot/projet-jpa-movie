/**
 * 
 */
package fr.diginamic.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Représente un acteur (Data Transfer Object) à déserialiser en entité
 * 
 * @author antPinot
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActeurDto {

	/** idImdb clé métier de la base Imdb */
	@JsonProperty("id")
	private String idImdb;
	
	/** identite nom de l'acteur */
	@JsonProperty("identite")
	private String identite;

	/** dateNaissance */
	private LocalDate dateNaissance;
	
	/** lieuNaissance */
	private LieuDto lieuNaissance;
	
	/**
	 * Méthode utilisée par la méthode Jackson pour extraire les nested properties
	 * de l'objet naissance du JSON
	 * <p>
	 * Prévoit les différents cas de figure pour le lieu de naissance :
	 * ville,region,pays/
	 * ville,pays/
	 * region,pays/
	 * quartier,ville,region,pays(dans ce cas de figure le quartier est ignoré)
	 * <p>
	 * Prévoit les différents cas de figure pour la date de naisance :
	 * date de naissance absente/
	 * mois à 0/
	 * jour à 0/
	 * année à 0/
	 * 
	 * @param naissanceObject
	 */
	@JsonProperty("naissance")
	private void unpack(Map<String, String> naissanceObject) {
		if (naissanceObject != null) {
			String lieuNaissanceString = naissanceObject.get("lieuNaissance");
			if (lieuNaissanceString != null) {
				String[] lieuNaissanceDecoupe = lieuNaissanceString.split(",");
				if (lieuNaissanceDecoupe.length == 3) {
					this.lieuNaissance = new LieuDto(lieuNaissanceDecoupe[0], lieuNaissanceDecoupe[1],
							new PaysDto(lieuNaissanceDecoupe[2]));
				} else if (lieuNaissanceDecoupe.length == 1) {
					this.lieuNaissance = new LieuDto(new PaysDto(lieuNaissanceDecoupe[0]));
				} else if (lieuNaissanceDecoupe.length == 2) {
					this.lieuNaissance = new LieuDto(lieuNaissanceDecoupe[0], new PaysDto(lieuNaissanceDecoupe[1]));
				} else if (lieuNaissanceDecoupe.length > 3) {
					this.lieuNaissance = new LieuDto(lieuNaissanceDecoupe[1], lieuNaissanceDecoupe[2],
							new PaysDto(lieuNaissanceDecoupe[3]));
				}
			}
			String date = naissanceObject.get("dateNaissance");
			if (StringUtils.isNotEmpty(date) && date.indexOf("-0-0") == -1 && !date.endsWith("-0")
					&& !date.startsWith("0-")) {
				this.dateNaissance = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-M-d"));
			}

		}

	}

	/**height hauteur de l'acteur */
	private String height;

	/**url lien imdb */
	private String url;

	/** roles liste(Set) des roles tenus par l'acteur*/
	private Set<RoleDto> roles = new HashSet<RoleDto>();

	/**
	 * Constructeur
	 * 
	 */
	public ActeurDto() {
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
	 * Getter pour l'attribut identite
	 * 
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}

	/**
	 * Setter pour l'attribut identite
	 * 
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
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
	public Set<RoleDto> getRoles() {
		return roles;
	}

	/**
	 * Setter pour l'attribut roles
	 * 
	 * @param roles the roles to set
	 */
	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	/**
	 * Getter pour l'attribut lieuNaissance
	 * 
	 * @return the lieuNaissance
	 */
	public LieuDto getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * Setter pour l'attribut lieuNaissance
	 * 
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(LieuDto lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	/**
	 * Getter pour l'attribut url
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter pour l'attribut url
	 * 
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ActeurDto [idImdb=" + idImdb + ", identite=" + identite + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", height=" + height + ", url=" + url + ", roles=" + roles + "]";
	}

}
