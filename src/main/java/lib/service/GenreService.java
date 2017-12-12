/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;
import lib.DAO.GenreDAO;
import lib.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class GenreService {
	@Autowired
	public GenreDAO genreDAO;

	public List<Genre> getGenre() {
		return genreDAO.fillAllGenre();
	}

	public List<Genre> getGenreById(Long id) {
		return genreDAO.fillGenreById(id);
	}

	public void updateGenre(Genre genre) {
		genreDAO.update(genre);
	}

	public void createGenre(Genre genre) {
		genreDAO.create(genre);
	}

	public void deleteGenre(Genre genre) {
		genreDAO.delete(genre);
	}
}
