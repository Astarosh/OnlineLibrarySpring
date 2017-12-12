/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import lib.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class GenreDAO {
	@Autowired
	public EntityManager em;
	
	public void update(Genre genre) {
		em.merge(genre);
	}

	public void create(Genre genre) {
		em.persist(genre);
	}

	public void delete(Genre genre) {
		if (em.contains(genre))
			em.remove(genre);
		else
			em.remove(em.merge(genre));
	}
	public List<Genre> fillAllGenre() {
		List<Genre> resultList = em.createQuery("from Genre ORDER BY name").getResultList();
		return resultList;
	}
	public List<Genre> fillGenreById(Long id) {
		List<Genre> resultList = em.createQuery("from Genre where id =" + id).getResultList();
		return resultList;
	}
}
