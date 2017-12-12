/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;
import lib.DAO.BookDAO;
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
public class BookService {

    @Autowired
    public BookDAO bookDAO;

    public List<Book> fillAllBooksLimit(int first, int last) {
        return bookDAO.fillAllBooksLimit(first, last);
    }

    public int fillAllBooksNumber() {
        return bookDAO.fillAllBooksNumber();
    }

    public List<Book> fillBookByBookNameLimit(String name, int first, int last) {
        return bookDAO.fillBookByBookNameLimit(name, first, last);
    }

    public int fillAllBookByBookName(String name) {
        return bookDAO.fillAllBookByBookName(name);
    }

    public List<Book> getBookById(Long id) {
        return bookDAO.fillBookById(id);
    }

    public List<Book> getBookByISBN(String ISBN) {
        return bookDAO.fillBookByISBN(ISBN);
    }

    public List<Book> fillBookByAuthorLimit(Author author) {
        return bookDAO.fillBookByAuthor(author);
    }

    public List<Book> fillBookByGenreLimit(Genre genre, int first, int last) {
        return bookDAO.fillBookByGenreLimit(genre, first, last);
    }

    public int fillAllBookByGenre(Genre genre) {
        return bookDAO.fillAllBookByGenre(genre);
    }

    public List<Book> fillBookByLetterLimit(String letter, int first, int last) {
        return bookDAO.fillBookByLetterLimit(letter, first, last);
    }

    public int fillAllBooksByLetter(String letter) {
        return bookDAO.fillAllBooksByLetter(letter);
    }

    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    public void createBook(Book book) {
        bookDAO.create(book);
    }

    public void deleteBook(Book book) {
        bookDAO.delete(book);
    }

}
