/**
 * 
 */
package fr.diginamic.dto;

/**
 * 
 * Représente un Pays (Data Transfer Object) à déserialiser en entité
 * 
 * @author antPinot
 *
 */
public class PaysDto {

	/** nom */
	private String nom;

	/** url */
	private String url;

	/**
	 * Constructeur
	 * 
	 */
	public PaysDto() {
	}

	/**
	 * Constructeur
	 * 
	 * @param nom
	 */
	public PaysDto(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour l'attribut nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
		return "PaysDto [nom=" + nom + ", url=" + url + "]";
	}

}
