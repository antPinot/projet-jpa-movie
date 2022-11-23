/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Pays;

/**
 * @author antPinot
 *
 */
public class LieuDao {
	
	public static Pays getPaysByNom(String nom, EntityManager em) {
		TypedQuery<Pays> queryPays = em.createQuery("SELECT p FROM Pays p WHERE p.nom = :param1", Pays.class);
		queryPays.setParameter("param1", nom);
		List<Pays> paysResult = queryPays.getResultList();

		if (paysResult.size() == 0) {
			return null;
		} else {
			return paysResult.get(0);
		}
	}
	
	public static void selectOrCreate(Pays pays, EntityManager em) {
		Pays query = getPaysByNom(pays.getNom(), em);
		if (query == null) {
			em.persist(pays);
		} else {
			pays.setId(query.getId());
		}
	}

}
