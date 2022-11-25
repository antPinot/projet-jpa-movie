/**
 * 
 */
package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author antPinot
 *
 */
public class RoleDto {

	private String characterName;

	@JsonProperty("acteur")
	private ActeurDto acteur;

	private String url;

	private String height;

	private String film;

	/**
	 * Constructeur
	 * 
	 */
	public RoleDto() {
	}

	/**
	 * Getter pour l'attribut characterName
	 * 
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * Setter pour l'attribut characterName
	 * 
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * Getter pour l'attribut film
	 * 
	 * @return the film
	 */
	public String getFilm() {
		return film;
	}

	/**
	 * Setter pour l'attribut film
	 * 
	 * @param film the film to set
	 */
	public void setFilm(String film) {
		this.film = film;
	}

	/**
	 * Getter pour l'attribut acteur
	 * 
	 * @return the acteur
	 */
	public ActeurDto getActeur() {
		return acteur;
	}

	/**
	 * Setter pour l'attribut acteur
	 * 
	 * @param acteur the acteur to set
	 */
	public void setActeur(ActeurDto acteur) {
		this.acteur = acteur;
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

	@Override
	public String toString() {
		return "RoleDto [characterName=" + characterName + ", acteur=" + acteur + ", url=" + url + ", height=" + height
				+ ", film=" + film + "]";
	}

}
