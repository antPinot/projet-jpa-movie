/**
 * 
 */
package fr.diginamic.dto;

/**
 * @author antPinot
 *
 */
public class RealisateurDto {

	private String identite;

	private String url;

	/**
	 * Constructeur
	 * 
	 */
	public RealisateurDto() {
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
		return "RealisateurDto [identite=" + identite + ", url=" + url + "]";
	}

}
