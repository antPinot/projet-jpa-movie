/**
 * 
 */
package fr.diginamic.manager;

import javax.persistence.EntityManager;

import fr.diginamic.dao.LieuDao;
import fr.diginamic.entites.Lieu;

/**
 * @author antPinot
 *
 */
public class LieuService {

	private LieuDao lieuDao;

	/**
	 * Constructeur
	 * 
	 * @param lieuDao
	 */
	public LieuService(EntityManager em) {
		this.lieuDao = new LieuDao(em);
	}

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
