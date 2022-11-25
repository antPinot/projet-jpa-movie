package fr.diginamic.manager;

import javax.persistence.EntityManager;

import fr.diginamic.dao.PaysDao;
import fr.diginamic.entites.Pays;

/**
 * @author antPinot
 *
 */
public class PaysService {

	private PaysDao paysDao;

	/**
	 * Constructeur
	 * 
	 * @param paysDao
	 */
	public PaysService(EntityManager em) {
		this.paysDao = new PaysDao(em);
	}

	public void selectOrCreate(Pays pays) {
		Pays query = paysDao.getPaysByNom(pays.getNom());
		if (query == null) {
			paysDao.insert(pays);
		} else {
			pays.setId(query.getId());
		}
	}

	/**
	 * Getter pour l'attribut paysDao
	 * 
	 * @return the paysDao
	 */
	public PaysDao getPaysDao() {
		return paysDao;
	}

	/**
	 * Setter pour l'attribut paysDao
	 * 
	 * @param paysDao the paysDao to set
	 */
	public void setPaysDao(PaysDao paysDao) {
		this.paysDao = paysDao;
	}

}
