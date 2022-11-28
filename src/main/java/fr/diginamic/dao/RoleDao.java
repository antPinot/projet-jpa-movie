/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Role;

/**
 * Classe d'accès à la base de données pour l'object Role
 * 
 * @author antPinot
 *
 */
public class RoleDao {

	/** em EntityManager pour les opérations avec la base de données*/
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public RoleDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Méthode qui recherche un rôle par le nom du personnage et l'acteur qui joue le rôle
	 * 
	 * @param characterName
	 * @param acteur
	 * @return le résultat de la requête s'il existe ou null si la requête n'a pas abouti à un résultat
	 */
	public Role getRoleByCharacterName(String characterName, String acteur) {
		TypedQuery<Role> queryRole = em.createQuery(
				"SELECT r FROM Role r JOIN r.acteurs a WHERE r.characterName = :param1 AND a.identite = :param2",
				Role.class);
		queryRole.setParameter("param1", characterName);
		queryRole.setParameter("param2", acteur);
		List<Role> rolesResult = queryRole.getResultList();

		if (rolesResult.size() == 0) {
			return null;
		} else {
			return rolesResult.get(0);
		}
	}

	/**
	 * Gère la persistance du rôle
	 * 
	 * @param role
	 */
	public void insert(Role role) {
		em.persist(role);
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
