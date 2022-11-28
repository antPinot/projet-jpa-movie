/**
 * 
 */
package fr.diginamic.manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.diginamic.dao.RoleDao;
import fr.diginamic.entites.Role;

/**
 * Classe de service qui fournit des méthodes de traitement des rôles
 * 
 * @author antPinot
 *
 */
public class RoleService {

	/** roleDao */
	private RoleDao roleDao;

	/**
	 * Constructeur
	 * 
	 * @param roleDao
	 */
	public RoleService(EntityManager em) {
		this.roleDao = new RoleDao(em);
	}

	/**
	 * Méthode qui insère un rôle s'il n'existe pas en base de données
	 * ou référence le rôle s'il existe
	 * 
	 * @param role
	 */
	public void selectOrCreate(Role role) {
		Role query = roleDao.getRoleByCharacterName(role.getCharacterName(),
				role.getActeurs().iterator().next().getIdentite());
		if (query == null) {
			roleDao.insert(role);
		} else {
			role.setId(query.getId());
		}
	}

	/**
	 * Méthode pour supprimer les doublons de réalisateurs dans un film
	 * 
	 * @param roles
	 */
	public static void removeDoublonsRole(Set<Role> roles) {
		HashMap<String, Role> gestionDoublons = new HashMap<String, Role>();
		Set<Role> doublonsToRemove = new HashSet<Role>();
		for (Role roleDoublons : roles) {
			if (gestionDoublons.put(roleDoublons.getCharacterName(), roleDoublons) != null) {
				doublonsToRemove.add(roleDoublons);
			}
		}
		roles.removeAll(doublonsToRemove);
	}

	/**
	 * Getter pour l'attribut roleDao
	 * 
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * Setter pour l'attribut roleDao
	 * 
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
