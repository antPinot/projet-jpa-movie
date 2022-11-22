/**
 * 
 */
package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

/**
 * @author antPinot
 *
 */
public class Reader {

	public List<Film> filmGenerator() throws StreamReadException, DatabindException, IOException {

		List<Film> internetMovieDatabase = new ArrayList<Film>();

		File fileToParse = new File(
				"C://Users//Saranthony//Documents//Reconversion Professionnelle//Apprentissage Programmation//Diginamic//Projet//17 - PROJET JPA//Projet 1 - Internet Movie Database//films.json");

		ObjectMapper mapper = new ObjectMapper();

		CollectionType collGenre = mapper.getTypeFactory().constructCollectionType(List.class, Genre.class);

		CollectionType collRole = mapper.getTypeFactory().constructCollectionType(List.class, Role.class);

		CollectionType collActeur = mapper.getTypeFactory().constructCollectionType(List.class, Acteur.class);

		CollectionType collRealisateur = mapper.getTypeFactory().constructCollectionType(List.class, Realisateur.class);

		List<Genre> genres = mapper.readValue(fileToParse, collGenre);
		
		List<Role> roles = mapper.readValue(fileToParse, collRole);
		
		List<Genre> acteurs = mapper.readValue(fileToParse, collActeur);
		
		List<Genre> realisateurs = mapper.readValue(fileToParse, collRealisateur);
		


		return internetMovieDatabase;
	}

}
