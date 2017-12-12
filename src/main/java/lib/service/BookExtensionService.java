/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import java.util.List;
import lib.bean.BookExtension;
import lib.bean.SearchType;
import lib.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Ast
 */
@Component
public class BookExtensionService {

    @Autowired
    SearchTypeService searchTypeService;
    @Autowired
    BookQuantityService bookQuantityService;
    @Autowired
    BookService bookService;

    
    private List<BookExtension> bookExtensionList;
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    private BookExtension bookExtension;

    public BookExtension createBookExtension() {
        bookExtension = new BookExtension();
        SearchType searchType = new SearchType();
        searchType.setSearchList(searchTypeService.populateList());
        bookExtension.setSearchType(searchType);
        return bookExtension;
    }

    public List<BookExtension> populateList() {
        bookQuantityService = new BookQuantityService();
        int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
        bookList = bookService.fillAllBooksLimit(0, booksPerPage);
//        for (int i = 0; i < booksPerPage; i++) {
//            bookExtension.setBook(bookService.getBooks(0, 2));
//            bookExtensionList.add(bookExtension);
//        }
        return null;
    }

    public BookExtension getBookExtension() {
        return bookExtension;
    }

    public void setBookExtension(BookExtension bookExtension) {
        this.bookExtension = bookExtension;
    }

    public List<BookExtension> getBookExtensionList() {
        return bookExtensionList;
    }

    public void setBookExtensionList(List<BookExtension> bookExtensionList) {
        this.bookExtensionList = bookExtensionList;
    }

}
