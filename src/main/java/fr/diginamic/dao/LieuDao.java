/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Lieu;

/**
 * @author antPinot
 *
 */
public class LieuDao {

	public static Lieu getLieuByDatas(String libelle, String complement, String nom, EntityManager em) {
		TypedQuery<Lieu> queryLieu = em.createQuery(
				"SELECT l FROM Lieu l WHERE l.libelle= :param1 AND l.complement= :param2 AND l.pays.nom = :param3",
				Lieu.class);
		queryLieu.setParameter("param1", libelle);
		queryLieu.setParameter("param2", complement);
		queryLieu.setParameter("param3", nom);
		List<Lieu> lieuResult = queryLieu.getResultList();

		if (lieuResult.size() == 0) {
			return null;
		} else {
			return lieuResult.get(0);
		}
	}

	public static void selectOrCreate(Lieu lieu, EntityManager em) {
			Lieu query = getLieuByDatas(lieu.getLibelle(), lieu.getComplement(), lieu.getPays().getNom(), em);
			if (query == null) {
				em.persist(lieu);
			} else {
				lieu.setId(query.getId());
			}
		}

	}
