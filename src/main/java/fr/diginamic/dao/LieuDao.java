/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Lieu;

/**
 * Classe d'accès à la base de données pour l'object Lieu
 * 
 * @author antPinot
 *
 */
public class LieuDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public LieuDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un lieu par le libellé, le complément et le nom du pays
	 * 
	 * @param libelle (généralement la ville, plus rarement la région/état)
	 * @param complement 
	 * @param nom nom du Pays
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
	public Lieu getLieuByDatas(String libelle, String complement, String nom) {
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

	/**
	 * Gère la persistance du lieu
	 * 
	 * @param lieu
	 */
	public void insert(Lieu lieu) {
		em.persist(lieu);
	}

	/**
	 * Getter pour l'attribut em
	 * 
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Setter pour l'attribut em
	 * 
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
