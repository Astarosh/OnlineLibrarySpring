/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;
import lib.DAO.PublisherDAO;
import lib.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class PublisherService {
	@Autowired
	public PublisherDAO publisherDAO;
	
	public List<Publisher> getPublisher() {
		return publisherDAO.fillAllPublisher();
	}
	public List<Publisher> getPublisherById(Long id) {
		return publisherDAO.fillPublisherById(id);
	}
	public void updatePublisher(Publisher publisher) {
		publisherDAO.update(publisher);
	}
	public void createPublisher(Publisher publisher) {
		publisherDAO.create(publisher);
	}
	public void deletePublisher(Publisher publisher) {
		publisherDAO.delete(publisher);
	}
}