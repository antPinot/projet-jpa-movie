package fr.diginamic.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

public class ParseTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		File fileToParse = new File(
				"C://Users//Saranthony//Documents//Reconversion Professionnelle//Apprentissage Programmation//Diginamic//Projet//17 - PROJET JPA//Projet 1 - Internet Movie Database//films.json");

		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		CollectionType collFilm = mapper.getTypeFactory().constructCollectionType(List.class, FilmDto.class);

		/*CollectionType collGenre = mapper.getTypeFactory().constructCollectionType(List.class, Genre.class);

		CollectionType collRole = mapper.getTypeFactory().constructCollectionType(List.class, Role.class);

		CollectionType collActeur = mapper.getTypeFactory().constructCollectionType(List.class, Acteur.class);

		CollectionType collRealisateur = mapper.getTypeFactory().constructCollectionType(List.class, Realisateur.class)*/
		
		List<FilmDto> films = mapper.readValue(fileToParse, collFilm);
		
		/*List<Genre> genres = mapper.readValue(fileToParse, collGenre);
		
		List<Role> roles = mapper.readValue(fileToParse, collRole);
		
		List<Genre> acteurs = mapper.readValue(fileToParse, collActeur);
		
		List<Genre> realisateurs = mapper.readValue(fileToParse, collRealisateur);
		
		System.out.println(genres);*/
		
		System.out.println(films.get(1));

	}

}
