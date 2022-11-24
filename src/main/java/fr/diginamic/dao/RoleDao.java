/**
 * 
 */
package fr.diginamic.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class RoleDao {
	
	public static Role getRoleByCharacterName(String characterName, String acteur, EntityManager em) {
		TypedQuery<Role> queryRole = em.createQuery("SELECT r FROM Role r JOIN r.acteurs a WHERE r.characterName = :param1 AND a.identite = :param2",
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
	public static void selectOrCreate(Role role, EntityManager em) {
		Role query = getRoleByCharacterName(role.getCharacterName(), role.getActeurs().iterator().next().getIdentite(),em);
		if (query == null) {
			em.persist(role);
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
}

