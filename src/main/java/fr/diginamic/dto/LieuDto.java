/**
 * 
 */
package fr.diginamic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Représente un Lieu (Data Transfer Object) à déserialiser en entité
 * 
 * @author antPinot
 *
 */
public class LieuDto {

	/** libelle */
	@JsonProperty("ville")
	private String libelle;
	
	/** complement */
	@JsonProperty("etatDept")
	private String complement;
	
	/** pays */
	private PaysDto pays;

	/**
	 * Constructeur
	 * 
	 */
	public LieuDto() {
	}

	/**
	 * Constructeur
	 * 
	 * @param pays
	 */
	public LieuDto(PaysDto pays) {
		super();
		this.pays = pays;
	}

	/**
	 * Constructeur
	 * 
	 * @param ville
	 * @param pays
	 */
	public LieuDto(String ville, PaysDto pays) {
		super();
		this.libelle = ville;
		this.pays = pays;
	}

	/**
	 * Constructeur
	 * 
	 * @param ville
	 * @param etatDept
	 * @param pays
	 */
	public LieuDto(String ville, String etatDept, PaysDto pays) {
		super();
		this.libelle = ville;
		this.complement = etatDept;
		this.pays = pays;
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

	/**
	 * Getter pour l'attribut complement
	 * 
	 * @return the complement
	 */
	public String getComplement() {
		return complement;
	}

	/**
	 * Setter pour l'attribut complement
	 * 
	 * @param complement the complement to set
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}

	/**
	 * Getter pour l'attribut pays
	 * 
	 * @return the pays
	 */
	public PaysDto getPays() {
		return pays;
	}

	/**
	 * Setter pour l'attribut pays
	 * 
	 * @param pays the pays to set
	 */
	public void setPays(PaysDto pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "LieuDto [libelle=" + libelle + ", complement=" + complement + ", pays=" + pays + "]";
	}

}
