/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import lib.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class AuthorDAO {
	@Autowired
	public EntityManager em;

	public void update(Author author) {
		em.merge(author);
	}

	public void create(Author author) {
		em.persist(author);
	}

	public void delete(Author author) {
		if (em.contains(author))
			em.remove(author);
		else
			em.remove(em.merge(author));
	}

	public List<Author> fillAllAuthors() {
		List<Author> resultList = em.createQuery("from Author").getResultList();
		return resultList;
	}

	public List<Author> fillAuthorsByName(String name) {
		List<Author> resultList = em.createQuery("from Author where fio LIKE '%"+name +"%'").getResultList();
		return resultList;
	}

	public List<Author> fillAuthorsById(Long id) {
		List<Author> resultList = em.createQuery("from Author where id =" + id).getResultList();
		return resultList;
	}
}
