/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import lib.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class PublisherDAO {

	@Autowired
	public EntityManager em;

	public void update(Publisher publisher) {
		em.merge(publisher);
	}

	public void create(Publisher publisher) {
		em.persist(publisher);
	}

	public void delete(Publisher publisher) {
		if (em.contains(publisher))
			em.remove(publisher);
		else
			em.remove(em.merge(publisher));
	}
	public List<Publisher> fillAllPublisher() {
		List<Publisher> resultList = em.createQuery("from Publisher").getResultList();
		return resultList;
	}
	public List<Publisher> fillPublisherById(Long id) {
		List<Publisher> resultList = em.createQuery("from Publisher where id =" + id).getResultList();
		return resultList;
	}
}