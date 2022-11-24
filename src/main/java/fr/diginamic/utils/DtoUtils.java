/**
 * 
 */
package fr.diginamic.utils;


import java.util.HashSet;
import java.util.Set;

import fr.diginamic.dto.ActeurDto;
import fr.diginamic.dto.GenreDto;
import fr.diginamic.dto.LieuDto;
import fr.diginamic.dto.PaysDto;
import fr.diginamic.dto.RealisateurDto;
import fr.diginamic.dto.RoleDto;
import fr.diginamic.entites.Acteur;
import fr.diginamic.entites.Film;
import fr.diginamic.entites.Genre;
import fr.diginamic.entites.Lieu;
import fr.diginamic.entites.Pays;
import fr.diginamic.entites.Realisateur;
import fr.diginamic.entites.Role;

/**
 * Cette classe fournit des méthodes pour convertir les Dto en entités
 * 
 * @author antPinot
 *
 */
public class DtoUtils {

	
	/**
	 * Méthode pour construire un Pays à partir des attributs du PaysDto
	 * 
	 * @param paysToConvert PaysDto à convertir en entité
	 * @return convertedPays le pays converti ou null si le paysDto n'existe pas
	 */
	public static Pays paysDtoToPays(PaysDto paysToConvert) {
		if (paysToConvert != null) {
			Pays convertedPays = new Pays(paysToConvert.getNom(), paysToConvert.getUrl());
			return convertedPays;
		}
		return null;
	}
	
	/**
	 * Méthode pour construire un Lieu à partir des attributs du LieuDto
	 * 
	 * @param lieuToConvert le LieuDto à convertir en entité
	 * @return convertedLieu le lieu converti ou null si le LieuDto n'existe pas
	 */
	public static Lieu lieuDtoToLieu(LieuDto lieuToConvert) {
		if (lieuToConvert != null) {
			Lieu convertedLieu = new Lieu(lieuToConvert.getLibelle(), lieuToConvert.getComplement(),
					paysDtoToPays(lieuToConvert.getPays()));
			return convertedLieu;
		}
		return null;
	}

	/**
	 * Méthode pour construire un Genre à partir des attributs du GenreDto
	 * 
	 * @param genreToConvert le GenreDto à convertir en entité
	 * @return convertedGenre le genre converti 
	 */
	public static Genre genreDtoToGenre(GenreDto genreToConvert) {
		Genre convertedGenre = new Genre(genreToConvert.getLibelle());
		return convertedGenre;
	}
	
	/**
	 * Méthode pour construire un Acteur à partir des attributs de l'ActeurDto
	 * 
	 * @param acteurToConvert l'ActeurDto à convertir en entité
	 * @return convertedActeur l'Acteur converti 
	 */
	public static Acteur acteurDtoToActeur(ActeurDto acteurToConvert) {
		Acteur convertedActeur = new Acteur(acteurToConvert.getIdentite(), acteurToConvert.getUrl(),
				acteurToConvert.getIdImdb(), acteurToConvert.getHeight(), acteurToConvert.getDateNaissance(),lieuDtoToLieu(acteurToConvert.getLieuNaissance()));
		return convertedActeur;

	}

	
	/**
	 * Méthode pour construire un Role à partir des attributs de RoleDto
	 * 
	 * @param roleToConvert le RoleDto à convertir en entité
	 * @return convertedRole le Role converti
	 */
	public static Role roleDtoToRole(RoleDto roleToConvert) {
		Role convertedRole = new Role(roleToConvert.getCharacterName(), roleToConvert.getUrl(),
				roleToConvert.getHeight());
		convertedRole.getActeurs().add(acteurDtoToActeur(roleToConvert.getActeur()));
		convertedRole.getFilms().add(new Film(roleToConvert.getFilm()));
		return convertedRole;
	}
	
	
	/**
	 * Méthode pour construire un réalisateur à partir des attributs de RealisateurDto
	 * 
	 * @param realisateurToConvert le RealisateurDto à convertir en entité
	 * @return convertedRealisateur le Realisateur converti
	 */
	public static Realisateur realisateurDtoToRealisateur(RealisateurDto realisateurToConvert){
		Realisateur convertedRealisateur = new Realisateur(realisateurToConvert.getIdentite(), realisateurToConvert.getUrl());
		return convertedRealisateur;
	}
	
	/**
	 * Méthode pour construire un Genre à partir des attributs du GenreDto
	 * 
	 * @param genreToConvert le GenreDto à convertir en entité
	 * @return convertedGenre le genre converti 
	 */
	public static Set<Role> roleDtoListToRoleList(Set<RoleDto> roleListToConvert){
		Set<Role> convertedRoleList = new HashSet<Role>();
		for (RoleDto roles : roleListToConvert) {
			convertedRoleList.add(roleDtoToRole(roles));
		}
		return convertedRoleList;
	}

	public static Set<Genre> genreDtoListToGenreList(Set<GenreDto> genreListToConvert) {
		Set<Genre> convertedGenreList = new HashSet<Genre>();
		for (GenreDto genres : genreListToConvert) {
			convertedGenreList.add(genreDtoToGenre(genres));
		}
		return convertedGenreList;
	}
	
	public static Set<Acteur> acteurDtoListToActeurList(Set<ActeurDto> acteurListToConvert){
		Set<Acteur> convertedActeurList = new HashSet<Acteur>();
		for (ActeurDto acteurs : acteurListToConvert) {
			convertedActeurList.add(acteurDtoToActeur(acteurs));
		}
		return convertedActeurList;
	}
	
	public static Set<Realisateur> realisateurDtoListToRealisateurList(Set<RealisateurDto> realisateurListToConvert){
		Set<Realisateur> convertedRealisateurList = new HashSet<Realisateur>();
		for (RealisateurDto realisateurs : realisateurListToConvert) {
			convertedRealisateurList.add(realisateurDtoToRealisateur(realisateurs));
		}
		return convertedRealisateurList;
	}
}
