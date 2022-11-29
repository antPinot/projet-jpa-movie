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

import fr.diginamic.dao.FilmDao;
import fr.diginamic.entites.Film;

/**
 * Classe de test des méthodes de FilmDao
 * 
 * @author antPinot
 *
 */
public class FilmDaoTest {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet-jpa-movie");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	FilmDao filmDao = new FilmDao(em);

	@Test
	public void testGetFilmByNom() {
		Film resultat = filmDao.getFilmByNom("Jurassic World: Fallen Kingdom - The Trailer Rescue");
		assertEquals("Jurassic World: Fallen Kingdom - The Trailer Rescue", resultat.getNom());
	}
	
	@Test
	public void testGetFilmographie() {
		List<Film> listResultat = filmDao.getFilmographie("Chris Pratt");
		assertEquals(28, listResultat.size());
	}
	
	@Test
	public void testGetFilmsEntreDeuxAnnees() {
		List<Film> listResultat = filmDao.getFilmsEntreDeuxAnnees("2018", "2022");
		assertEquals(213, listResultat.size());
	}
	
	@Test
	public void testGetFilmsEntreDeuxAnneesActeur() {
		List<Film> listResultat = filmDao.getFilmsEntreDeuxAnneesActeur("2018", "2022", "Chris Pratt");
		assertEquals(8, listResultat.size());
	}

}
