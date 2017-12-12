/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lib.entity.Author;
import lib.entity.Book;
import lib.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class BookDAO {

    @Autowired
    public EntityManager em;

    public void update(Book book) {
        em.merge(book);
    }

    public void create(Book book) {
        em.persist(book);
    }

    public void delete(Book book) {
        if (em.contains(book)) {
            em.remove(book);
        } else {
            em.remove(em.merge(book));
        }
    }

    public List<Book> fillAllBooksLimit(int first, int last) {
        List<Book> resultList;
        resultList = (List<Book>) em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b ORDER BY b.name").setFirstResult(first).setMaxResults(last).getResultList();
        return resultList;
    }

    public int fillAllBooksNumber() {
        List<Book> resultList;
        resultList = (List<Book>) em.createQuery("SELECT NEW Book (b.id) FROM Book b").getResultList();
        return resultList.size();
    }

    public List<Book> fillBookById(Long id) {
        List<Book> resultList = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b where b.id =" + id).getResultList();
        return resultList;
    }

    public List<Book> fillBookByISBN(String ISBN) {
        List<Book> resultList;
        resultList = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b where b.isbn =" + ISBN).getResultList();
        return resultList;
    }

    public List<Book> fillBookByBookNameLimit(String name, int first, int last) {
        List<Book> resultList;
        Query query = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b where b.name LIKE :x");
        query.setParameter("x", "%" + name + "%");
        resultList = query.setFirstResult(first).setMaxResults(last).getResultList();
        return resultList;
    }

    public int fillAllBookByBookName(String name) {
        List<Book> resultList;
        Query query = em.createQuery("SELECT NEW Book (b.id) FROM Book b WHERE b.name LIKE :x");
        query.setParameter("x", "%" + name + "%");
        resultList = query.getResultList();
        return resultList.size();
    }

    public List<Book> fillBookByAuthor(Author author) {
        List<Book> resultList;
        resultList = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b where b.author.id =" + author.getId() + " ORDER BY b.name").getResultList();
        return resultList;
    }

    public List<Book> fillBookByGenreLimit(Genre genre, int first, int last) {
        List<Book> resultList = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b WHERE b.genre.id =" + genre.getId() + " ORDER BY b.name").setFirstResult(first).setMaxResults(last).getResultList();
        return resultList;
    }

    public int fillAllBookByGenre(Genre genre) {
        List<Book> resultList;
        resultList = (List<Book>) em.createQuery("SELECT NEW Book (b.id) FROM Book b WHERE b.genre.id=" + genre.getId()).getResultList();
        return resultList.size();
    }

    public List<Book> fillBookByLetterLimit(String letter, int first, int last) {
        List<Book> resultList = em.createQuery("SELECT NEW Book (b.id, b.author, b.genre, b.publisher, b.name, b.pageCount, b.isbn, b.publishYear, b.image, b.descr, b.rating, b.voteCount, b.viewDate, b.addDate) FROM Book b WHERE b.name LIKE '" + letter + "%'" + " ORDER BY b.name").setFirstResult(first).setMaxResults(last).getResultList();
        return resultList;
    }

    public int fillAllBooksByLetter(String letter) {
        List<Book> resultList;
        resultList = (List<Book>) em.createQuery("SELECT NEW Book (b.id) FROM Book b WHERE b.name LIKE '" + letter + "%'").getResultList();
        return resultList.size();
    }
}
