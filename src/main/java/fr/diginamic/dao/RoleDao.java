/**
 * 
 */
package fr.diginamic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class RoleDao {
	
	public static Role getRoleByCharacterName(String characterName, EntityManager em) {
		TypedQuery<Role> queryRole = em.createQuery("SELECT r FROM Role r WHERE r.characterName = :param1",
				Role.class);
		queryRole.setParameter("param1", characterName);
		List<Role> rolesResult = queryRole.getResultList();
	
	
	if (rolesResult.size() == 0) {
		return null;
	} else {
		return rolesResult.get(0);
	}
}
	public static void selectOrCreate(Role role, EntityManager em) {
		Role query = getRoleByCharacterName(role.getCharacterName(), em);
		if (query == null) {
			em.persist(role);
		} else {
			role.setId(query.getId());
		}
	}
}

