/**
 * 
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;

import fr.diginamic.dao.LieuDao;
import fr.diginamic.entites.Lieu;

/**
 * 
 * Classe de service qui fournit des méthodes de traitement des lieux
 * 
 * @author antPinot
 *
 */
public class LieuService {

	/** lieuDao */
	private LieuDao lieuDao;

	/**
	 * Constructeur
	 * 
	 * @param lieuDao
	 */
	public LieuService(EntityManager em) {
		this.lieuDao = new LieuDao(em);
	}

	/**
	 * Méthode qui insère un lieu s'il n'existe pas en base de données
	 * ou référence le lieu s'il existe
	 * 
	 * @param lieu
	 */
	public void selectOrCreate(Lieu lieu) {
		Lieu query = lieuDao.getLieuByDatas(lieu.getLibelle(), lieu.getComplement(), lieu.getPays().getNom());
		if (query == null) {
			lieuDao.insert(lieu);
		} else {
			lieu.setId(query.getId());
		}
	}

	/**Getter pour l'attribut lieuDao
	 * @return the lieuDao
	 */
	public LieuDao getLieuDao() {
		return lieuDao;
	}

	/**Setter pour l'attribut lieuDao
	 * @param lieuDao the lieuDao to set
	 */
	public void setLieuDao(LieuDao lieuDao) {
		this.lieuDao = lieuDao;
	}

}
