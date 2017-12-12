/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;
import lib.DAO.AuthorDAO;
import lib.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class AuthorService {
	
	@Autowired
	public AuthorDAO authorDAO;
	
	public List<Author> getAuthors() {
		return authorDAO.fillAllAuthors();
	}
	public List<Author> getAuthorsByName(String name) {
		return authorDAO.fillAuthorsByName(name);
	}
	public List<Author> getAuthorsById(Long id) {
		return authorDAO.fillAuthorsById(id);
	}
	public void updateAuthor(Author author) {
		authorDAO.update(author);
	}
	public void createAuthor(Author author) {
		authorDAO.create(author);
	}
	public void deleteAuthor(Author author) {
		authorDAO.delete(author);
	}
}