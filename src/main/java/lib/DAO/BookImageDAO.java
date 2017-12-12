/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import lib.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class BookImageDAO {

    private Long bookId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Autowired
    public EntityManager em;

    public List<Book> fillBookById(Long id) {
        List<Book> resultList = em.createQuery("from Book where id =" + id).getResultList();
        return resultList;
    }
}
