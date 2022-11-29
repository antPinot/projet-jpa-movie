/**
 * 
 */
package dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.diginamic.dao.ActeurDao;
import fr.diginamic.entites.Acteur;

/**
 * Classe de test des méthodes d'ActeurDao
 * 
 * @author antPinot
 *
 */
public class ActeurDaoTest {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-movie");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	ActeurDao acteurDao = new ActeurDao(em);

	@Test
	public void testGetActeurByIdentite() {
		Acteur resultat = acteurDao.getActeurByIdentite("Chris Pratt");
		assertEquals("Chris Pratt", resultat.getIdentite());
	}
	
	@Test
	public void testGetCasting() {
		List<Acteur> castingResultat = acteurDao.getCasting("The Electric State");
		assertEquals(2, castingResultat.size());
	}

}
