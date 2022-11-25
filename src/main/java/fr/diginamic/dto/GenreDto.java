/**
 * 
 */
package fr.diginamic.dto;

/**
 * Représente un Genre (Data Transfer Object) à déserialiser en entité
 * 
 * @author antPinot
 *
 */
public class GenreDto {
	
	/** libelle */
	private String libelle;

	/**
	 * Constructeur
	 * 
	 */
	public GenreDto() {
	}

	/**
	 * Constructeur
	 * 
	 * @param libelle
	 */
	public GenreDto(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter pour l'attribut libelle
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter pour l'attribut libelle
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "GenreDto [libelle=" + libelle + "]";
	}

}
