/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.controllers;

import java.util.List;
import javax.validation.Valid;
import lib.bean.BookExtension;
import lib.bean.SearchType;
import lib.entity.Author;
import lib.entity.Book;
import lib.entity.Genre;
import lib.service.AuthorService;
import lib.service.BookQuantityService;
import lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ast
 */
@Controller
public class SearchController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @Autowired
    BookQuantityService bookQuantityService;

    @RequestMapping(value = "/showBooks", method = RequestMethod.POST)
    public String showBookBySearch(@ModelAttribute("bookExtension") @Valid BookExtension bookExtension, BindingResult result,
            ModelMap model
    ) {
        int pageNumber = bookQuantityService.getBookQuanity().getPageNumber();
        int booksPerPage = bookQuantityService.getBookQuanity().getBooksPerPage();
        int totalBooksCount = 0;
        String searchString = bookExtension.getSearchString();
        List<Book> bookList = null;
        if ("".equals(searchString)) {
            totalBooksCount = bookService.fillAllBooksNumber();
            bookList = bookService.fillAllBooksLimit(pageNumber - 1, booksPerPage);
            model.put("bookList", bookList);
            model.put("bookListLength", totalBooksCount);
        } else if (bookExtension.getSearchType().getSearchType() == SearchType.SearchTypes.NAME) {
            totalBooksCount = bookService.fillAllBookByBookName(searchString);
            bookList = bookService.fillBookByBookNameLimit(searchString, pageNumber - 1, booksPerPage);
            model.put("bookList", bookList);
            model.put("bookListLength", totalBooksCount);
        } else if (bookExtension.getSearchType().getSearchType() == SearchType.SearchTypes.ISBN) {
            bookList = bookService.getBookByISBN(searchString);
            model.put("bookList", bookList);
            model.put("bookListLength", totalBooksCount);
        } else if (bookExtension.getSearchType().getSearchType() == SearchType.SearchTypes.AUTHOR) {
            List<Author> list;
            list = (List<Author>) authorService.getAuthorsByName(searchString);
            List<Author> authorList = null;
            list.stream().filter((author) -> (author.getFio().contains(searchString))).forEachOrdered(authorList::add);
            for (Author author : authorList) {
                List<Book> bookListByAuthor = bookService.fillBookByAuthorLimit(author);
                totalBooksCount =+ bookListByAuthor.size();
                bookList.addAll(bookListByAuthor);
            }
            model.put("bookList", bookList.subList(pageNumber, booksPerPage));
            model.put("bookListLength", totalBooksCount);
        }
        return "views/result";
    }
}
