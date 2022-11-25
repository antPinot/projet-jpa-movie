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
 * @author antPinot
 *
 */
public class RoleService {

	private RoleDao roleDao;

	/**
	 * Constructeur
	 * 
	 * @param roleDao
	 */
	public RoleService(EntityManager em) {
		this.roleDao = new RoleDao(em);
	}

	public void selectOrCreate(Role role) {
		Role query = roleDao.getRoleByCharacterName(role.getCharacterName(),
				role.getActeurs().iterator().next().getIdentite());
		if (query == null) {
			roleDao.insert(role);
		} else {
			role.setId(query.getId());
		}
	}

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
