/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.service;

import lib.bean.BookQuantity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ast
 */
@Component
public class BookQuantityService {

    private BookQuantity bookQuanity;

    public BookQuantity getBookQuanity() {
        return bookQuanity;
    }

    public void setBookQuanity(BookQuantity bookQuanity) {
        this.bookQuanity = bookQuanity;
    }

    public void changeValues(int pageNumber, int booksPerPage, int totalBooksCount) {
        bookQuanity.setBooksPerPage(booksPerPage);
        bookQuanity.setPageNumber(pageNumber);
        bookQuanity.setTotalBooksCount(totalBooksCount);
    }

    public void changeValuesToDefault() {
        bookQuanity.setBooksPerPage(2);
        bookQuanity.setPageNumber(1);
    }

    public BookQuantityService() {
        bookQuanity = new BookQuantity();
        bookQuanity.setBooksPerPage(2);
        bookQuanity.setPageNumber(1);
    }

}
